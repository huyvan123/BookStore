package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BookModel.Address;
import BookModel.Order;
import BookModel.Statistic;
import BookModel.Cart;
import BookModel.CreditCard;
import BookModel.Customer;
import DAOClass.CardDAO;
import DAOClass.CartDAO;
import DAOClass.CustomerNormalDAO;
import DAOClass.OrderDAO;
import DAOClass.StatisticDAO;

/**
 * Servlet implementation class Order
 */
@WebServlet("/Order")
public class OrderCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderCtrl() {
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
		// customer
		Customer customer = (Customer) session.getAttribute("customer");
		CustomerNormalDAO cusdao = new CustomerNormalDAO();
		customer.connectDB(cusdao);
		Address address = new Address(request.getParameter("country"), request.getParameter("city"),
				request.getParameter("district"), request.getParameter("street"), request.getParameter("lane"),
				request.getParameter("no"));
		String payment = request.getParameter("payment");
		// order
		Order order = null;
		// cart
		Cart cart = new Cart();
		cart.setCustomer(customer);
		CartDAO cartdao = new CartDAO();
		cart.connectDB(cartdao);
		ArrayList<Cart> listCart = cart.getCartdao().getCartByUserName(cart);
		//add Statistic
		Statistic sta = new Statistic();
		sta.setPerchaseQuantity(1);
		sta.setViewQuantity(0);
		StatisticDAO sdao = new StatisticDAO();
		sta.connectDB(sdao);
		for (Cart cart2 : listCart) {
			sta.setBook(cart2.getBook());
			if(sta.getStadao().checkExist(sta)) {
				sta.getStadao().updateObject(sta);
			}else {
				sta.getStadao().addObject(sta);
			}
		}
		if (payment.compareTo("payoff") == 0) {
			for (Cart cart2 : listCart) {
				order = new Order(address, customer, payment, cart2);
				OrderDAO ordao = new OrderDAO();
				// query
				order.connectDB(ordao);
				order.getOrderdao().addWithOutCard(order);
				order.disconnectDB();
			}
			ArrayList<Integer> list = customer.getListIdCartFromIdCus();
			for (Integer i : list) {
				cart.setIdCart(i);
				cart.deleteCart();
			}
			request.setAttribute("checkOrder", 1);
			session.setAttribute("itemquantity", cart.getItemQuantity());
		} else {
			String cardname = new StringTokenizer(request.getParameter("paycard"), "-").nextToken().toString();
			String idcard = request.getParameter("cardnumber");
			CreditCard card = new CreditCard();
			card.setName(cardname);
			card.setIdCard(idcard);
			// query
			CardDAO carddao = new CardDAO();
			card.connectDB(carddao);
			if (card.checkIdCard()) {
				for (Cart cart2 : listCart) {
					order = new BookModel.Order(address, customer, payment, card,cart2);
					// query
					OrderDAO ordao = new OrderDAO();
					order.connectDB(ordao);
					order.addOrder();
					order.disconnectDB();
				}
				ArrayList<Integer> list = customer.getListIdCartFromIdCus();
				for (Integer i : list) {
					cart.setIdCart(i);
					cart.deleteCart();
				}
				request.setAttribute("checkOrder", 1);
				session.setAttribute("itemquantity", cart.getItemQuantity());
			} else {
				request.setAttribute("checkOrder", 0);
			}
			card.disconnectDB();
		}
		
		sta.disconnectDB();
		customer.disconnect();
		cart.disconnectDB();
		session.removeAttribute("customer");
		request.getRequestDispatcher("Order.jsp").forward(request, response);

		// doGet(request, response);
	}

}
