package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BookModel.Address;
import BookModel.Publisher;
import DAOClass.PublisherDAO;

/**
 * Servlet implementation class AddPublisher
 */
@WebServlet("/AddPublisher")
public class AddPublisher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPublisher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String phonenumber = request.getParameter("phonenumber");
		String country = request.getParameter("country");
		String address = request.getParameter("address");
		String  intro = request.getParameter("introduction");
		String email = request.getParameter("email");
		String website = request.getParameter("website");
		Address add = new Address((address)+", "+country);
		int rank = 0;
		try {
			rank = Integer.parseInt(request.getParameter("rank"));
		} catch (Exception e) {
			
		}
		Publisher publisher =  new Publisher(add, name, phonenumber, intro, website, rank, email);
		//add
		PublisherDAO pudao = new PublisherDAO();
		publisher.connectDB(pudao);
		publisher.addPublisher();
		publisher.disconnectDB();
		request.setAttribute("checkadd", 1);
		request.getRequestDispatcher("/AddPublisher.jsp").forward(request, response);
		//doGet(request, response);
	}

}
