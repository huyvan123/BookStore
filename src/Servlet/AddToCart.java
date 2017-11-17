package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BookModel.Account;
import BookModel.Book;
import BookModel.Cart;
import BookModel.Customer;
import DAOClass.CartDAO;
import DAOClass.CustomerNormalDAO;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			session.setAttribute("checkcenter", 2);
			request.setAttribute("checkaddtocart", 0);
		} else {
			int bookquantity = Integer.parseInt(request.getParameter("bookquantity"));
			Book book = (Book) session.getAttribute("book");
			Account account = new Account();
			account.setUserName(username);
			Customer customer = new Customer();
			CustomerNormalDAO dao = new CustomerNormalDAO();
			customer.setAccount(account);
			customer.connectDB(dao);
			customer = customer.findCustomerByUserName();
			customer.disconnect();
			Cart cart = new Cart(customer, bookquantity, book);
			//query
			CartDAO cartdao = new CartDAO();
			cart.connectDB(cartdao);
			cart.getIdCartFromCusAndBook();
			if (cart.getIdCart() != 0) {
				cart.updateQuantity(bookquantity);
			} else {
				session.setAttribute("itemquantity",
						(Integer.parseInt(session.getAttribute("itemquantity").toString()) + 1));
				cart.addCart();
			}
			cart.disconnectDB();
			session.setAttribute("checkcenter", 3);
			session.removeAttribute("book");
		}
		RequestDispatcher red = request.getRequestDispatcher("HomePage.jsp");
		red.forward(request, response);
		// doGet(request, response);
	}

}
