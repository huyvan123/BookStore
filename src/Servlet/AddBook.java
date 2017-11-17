package Servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import BookModel.Author;
import BookModel.Book;
import BookModel.Discount;
import BookModel.Publisher;
import DAOClass.BookNormalDAO;




/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "Image";
	private static String s="";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		if(request.getParameter("addbookbtn")!=null && s.compareTo("")!=0) {
			Author author = new Author();
			StringTokenizer toc = new StringTokenizer(request.getParameter("author"), ":");
			author.setIdauthor(Integer.parseInt(toc.nextToken().toString()));
			Publisher pu = new Publisher();
			toc = new StringTokenizer(request.getParameter("publisher"), ":");
			pu.setIdPublisher(Integer.parseInt(toc.nextToken().toString()));
			Discount discount = new Discount();
			try {
			toc = new StringTokenizer(request.getParameter("discount"), ":");
			discount.setId(Integer.parseInt(toc.nextToken().toString()));
			}catch(Exception e) {}
			String name = request.getParameter("bookname");
			Long price = Long.parseLong(request.getParameter("price"));
			String intro = request.getParameter("introduction");
			String image = s;
			int quantity = Integer.parseInt(request.getParameter("bookquantity"));
			String category = request.getParameter("bookcategory");
			Book book = new Book(name, author, pu, discount, price, image, intro, quantity, category);
			//add
			BookNormalDAO bookdao = new BookNormalDAO();
			book.connectDB(bookdao);
			book.addBook();
			book.disconnectDB();
			
			request.setAttribute("checkbook", 1);
			s = "";
		}
		else if(request.getParameter("addbookbtn")!=null && s.compareTo("")==0){
			request.setAttribute("checkbook", 0);
		}else {
			// checks if the request actually contains upload file
	        if (!ServletFileUpload.isMultipartContent(request)) {
	            return;
	        }
	 
	        // configures upload settings
	        DiskFileItemFactory factory = new DiskFileItemFactory();
	        // sets temporary location to store files
	        //factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
	        ServletFileUpload upload = new ServletFileUpload(factory);	 
	        String uploadPath = getServletContext().getRealPath("")
	                + File.separator + UPLOAD_DIRECTORY;
	 
	        // creates the directory if it does not exist
	        File uploadDir = new File(uploadPath);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdir();
	        }
	 
	        try {
	            List<FileItem> formItems = upload.parseRequest(request);
	 
	            if (formItems != null && formItems.size() > 0) {
	                // iterates over form's fields
	                for (FileItem item : formItems) {
	                    // processes only fields that are not form fields
	                    if (!item.isFormField()) {
	                        String fileName = new File(item.getName()).getName();
	                        String filePath = uploadPath + File.separator + fileName;
	                        File storeFile = new File(filePath);
	 
	                        // saves the file on disk
	                        item.write(storeFile);
	                        s = UPLOAD_DIRECTORY + "/" + fileName;
	                        request.setAttribute("message",
	                                 s);
	                    }
	                }
	            }
	        } catch (Exception ex) {
	            request.setAttribute("message",
	                    "There was an error: " + ex.getMessage());
	        }
		}
		RequestDispatcher red = request.getRequestDispatcher("/AddBook.jsp");
		red.forward(request, response);
		//doGet(request, response);
	}

}
