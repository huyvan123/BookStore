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
import BookModel.Cart;
import BookModel.Customer;
import DAOClass.CartDAO;
import DAOClass.CustomerNormalDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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
		//query
		Customer cus = new Customer();
		CustomerNormalDAO cusdao = new CustomerNormalDAO();
		CartDAO cartdao = new CartDAO();
		cus.connectDB(cusdao);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		cus.setAccount(new Account(username,password));
		if (cus.checkLogin()) {
			//cart
			Cart cart = new Cart();
			cart.connectDB(cartdao);
			session.setAttribute("username", username);
			cus = cus.findCustomerByUserName();
			cart.setCustomer(cus);
			int itemquantity = cart.getItemQuantity();
			session.setAttribute("itemquantity", itemquantity);
			session.setAttribute("checkcenter", 0);
			cus.disconnect();
			cart.disconnectDB();
			new Home().doGet(request, response);
		} else {
			request.setAttribute("check", 0);
			cus.disconnect();
			RequestDispatcher red = request.getRequestDispatcher("/Login.jsp");
			red.forward(request, response);
		}
		
		// doGet(request, response);
	}

}
