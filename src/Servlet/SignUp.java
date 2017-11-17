package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BookModel.Account;
import BookModel.Address;
import BookModel.Customer;
import BookModel.DateOfBirth;
import BookModel.Name;
import DAOClass.CustomerNormalDAO;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
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
		String firstname = request.getParameter("firstname");
		String secondname = request.getParameter("secondname");
		String lastname = request.getParameter("lastname");
		String dateofbirth = request.getParameter("birthdate");
		String country = request.getParameter("country");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String username = request.getParameter("usernamecus");
		String password = request.getParameter("passwordcus");
		String phonenumber = request.getParameter("phonenumber");
		String email = request.getParameter("email");
		
		Name name = new Name(firstname, secondname, lastname);
		Address add = new Address(address+", "+country);
		DateOfBirth dob = new DateOfBirth(dateofbirth);
		Account account = new Account(username, password);
		Customer customer = new Customer(name, add, dob, gender, account, phonenumber, email);
		CustomerNormalDAO cusdao = new CustomerNormalDAO();
		customer.connectDB(cusdao);
		if(customer.checkSignUp()) {
			request.setAttribute("checkUS", 0);
		}else {
			try {
			customer.addCustomer();
			request.setAttribute("checkUS", 1);
			}catch(Exception e) {
				request.setAttribute("checkUS", 0);
			}
		}
		customer.disconnect();
		RequestDispatcher red = request.getRequestDispatcher("/Login.jsp");
		red.forward(request, response);
		//doGet(request, response);
	}

}
