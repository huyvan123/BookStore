package Servlet;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class CartDetail
 */
@WebServlet("/CartDetail")
public class CartDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartDetail() {
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

		CustomerNormalDAO cusdao = new CustomerNormalDAO();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		// query customer
		Customer customer = new Customer();
		customer.connectDB(cusdao);
		Account account = new Account();
		account.setUserName(username);
		customer.setAccount(account);
		customer = customer.findCustomerByUserName();
		customer.connectDB(cusdao);
		System.out.println(customer.getIdCustomer());
		customer.getListBookOfCustomer();
		System.out.println(customer.getListBook().size());
		// cart
		Cart cart = new Cart();
		CartDAO cdao = new CartDAO();
		cart.setCustomer(customer);
		cart.connectDB(cdao);
		ArrayList<Cart> listCart = cart.getCartdao().getCartByUserName(cart);
		for (Book b : customer.getListBook()) {
			for (Cart cart2 : listCart) {
				if (b.getIdBook() == cart2.getBook().getIdBook()) {
					b.setQuantity(cart2.getBookquantity());
				}
			}
		}
		session.setAttribute("customer", customer);
		customer.disconnect();
		cart.disconnectDB();
		request.getRequestDispatcher("CartDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// doGet(request, response);
	}

}
