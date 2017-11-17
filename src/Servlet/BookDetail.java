package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BookModel.Book;
import BookModel.Statistic;
import DAOClass.BookNormalDAO;
import DAOClass.StatisticDAO;

/**
 * Servlet implementation class BookDetail
 */
@WebServlet("/BookDetail")
public class BookDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookDetail() {
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
		HttpSession session = request.getSession();
		int idbook = Integer.parseInt(request.getParameter("idbook"));
		Book book = new Book();
		book.setIdBook(idbook);
		//query book
		BookNormalDAO bookdao = new BookNormalDAO();
		book.connectDB(bookdao);
		book = book.bookDetail();
		book.disconnectDB();
		session.setAttribute("book", book);
		session.setAttribute("checkcenter", 2);
		//statistic
		Statistic sta = new Statistic(book,1,0);
		StatisticDAO sdao = new StatisticDAO();
		sta.connectDB(sdao);
		if(sta.getStadao().checkExist(sta)) {
			sta.getStadao().updateObject(sta);
		}else {
			sta.getStadao().addObject(sta);
		}
		
		RequestDispatcher red = request.getRequestDispatcher("/HomePage.jsp");
		red.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
		doGet(request, response);
	}

}
