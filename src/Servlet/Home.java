package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BookModel.Book;
import BookModel.Statistic;
import DAOClass.BookNormalDAO;
import DAOClass.StatisticDAO;

/**
 * Servlet implementation class Home
 */
// @WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Home() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		// query
		BookNormalDAO bookdao = new BookNormalDAO();
		Book book = new Book();
		book.connectDB(bookdao);
		// khi click next
		if (request.getParameter("next") != null) {
			System.out.println("vao next");
			book.setIdBook((Integer) session.getAttribute("idlastbook"));
			// query
			int idFirst = book.getIdBook() + 1;
			book.setIdBook(idFirst);
			ArrayList<Book> listB = book.searchBookByIdNextLimited(9);
			if (listB.size() == 0) {
				// request.setAttribute("checkv", "0");
				System.out.println("list size = 0");
			} else {
				if (listB.size() < 9) {
					request.setAttribute("checkv", "0");
				} else
					request.setAttribute("checkv", "1");
				book = listB.get(listB.size() - 1);
				int idLast = book.getIdBook();
				System.out.println("id first: " + idFirst);
				System.out.println("id last: " + idLast);
				session.setAttribute("idfirstbook", idFirst);
				session.setAttribute("idlastbook", idLast);
				request.setAttribute("listbook", listB);
			}
			// khi click previous
		} else if (request.getParameter("pre") != null) {
			System.out.println("vao pre");
			book.setIdBook((Integer) session.getAttribute("idfirstbook"));
			int idLast = book.getIdBook() - 1;
			book.setIdBook(idLast);
			// query
			ArrayList<Book> listB = book.searchBookByIdPreLimited(9);
			if (listB.size() == 0) {
				System.out.println("list size = 0");
			} else {
				if (listB.size() < 9) {
					request.setAttribute("checkv", "2");
				} else
					request.setAttribute("checkv", "1");
				book = listB.get(0);
				int idFirst = book.getIdBook();
				System.out.println("id first: " + idFirst);
				System.out.println("id last: " + idLast);
				session.setAttribute("idfirstbook", idFirst);
				session.setAttribute("idlastbook", idLast);
				request.setAttribute("listbook", listB);
			}
			// load khi vao trang chinh
		} else {
			// query
			int idFirst = book.getFirstID();
			book.setIdBook(idFirst);
			ArrayList<Book> listB = book.searchBookByIdNextLimited(9);
			System.out.println("listB size: " + listB.size());
			book = listB.get(listB.size() - 1);
			int idLast = book.getIdBook();
			System.out.println("id first: " + idFirst);
			System.out.println("id last: " + idLast);
			session.setAttribute("idfirstbook", idFirst);
			session.setAttribute("idlastbook", idLast);
			request.setAttribute("listbook", listB);
			request.setAttribute("checkv", "2");
		}
		// Statistic
		Statistic sta = new Statistic();
		StatisticDAO stadao = new StatisticDAO();
		sta.connectDB(stadao);
		ArrayList<Book> listB1 = sta.getStadao().getListBookView(sta);
		for (Book book2 : listB1) {
			System.out.println("name: "+book2.getName());
		}
		ArrayList<Book> listB2 = sta.getStadao().getListBookPerchase(sta);
		request.setAttribute("listbookView", listB1);
		request.setAttribute("listbookPurchase", listB2);

		sta.disconnectDB();
		book.disconnectDB();
		request.getRequestDispatcher("HomePage.jsp").forward(request, response);
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("fic");
		// doGet(request, response);
	}

}
