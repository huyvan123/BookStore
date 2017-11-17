package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BookModel.Book;
import DAOClass.BookNormalDAO;

/**
 * Servlet implementation class SearchBook
 */
@WebServlet("/SearchBook")
public class SearchBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBook() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		RequestDispatcher red = request.getRequestDispatcher("/HomePage.jsp");
		red.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		if(request.getParameter("staffsearchbtn")!=null) {
		RequestDispatcher red = request.getRequestDispatcher("/ViewSearch.jsp");
		red.forward(request, response);
		}else if(request.getParameter("homesearchbtn")!=null){
			String bookname = request.getParameter("homesearchbar");
			Book book = new Book();
			book.setName(bookname);
			//query
			BookNormalDAO bookdao = new BookNormalDAO();
			book.connectDB(bookdao);
			ArrayList<Book> listBook = book.searchBookByName();
			book.disconnectDB();
			request.setAttribute("listBook", listBook);
			session.setAttribute("checkcenter", 1);
			request.setAttribute("bookname", bookname);
			RequestDispatcher red = request.getRequestDispatcher("/HomePage.jsp");
			red.forward(request, response);
		}else {
			
			doGet(request, response);
		}
	}

}
