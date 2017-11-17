package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BookModel.Address;
import BookModel.Author;
import BookModel.DateOfBirth;
import BookModel.Name;
import DAOClass.AuthorDAO;

/**
 * Servlet implementation class AddAuthor
 */
@WebServlet("/AddAuthor")
public class AddAuthor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAuthor() {
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
		String introduction = request.getParameter("introduction");
		int exp =0;
		try {
		exp = Integer.parseInt(request.getParameter("exp"));
		}catch(Exception e) {
			
		}
		String phonenumber = request.getParameter("phonenumber");
		String email = request.getParameter("email");
		
		Name name = new Name(firstname, secondname, lastname);
		Address add = new Address(address+", "+country);
		DateOfBirth dob = new DateOfBirth(dateofbirth);
		Author author = new Author(name, add, dob, gender, phonenumber, email, exp, introduction);
		
		AuthorDAO daoau = new AuthorDAO();
		//add 
		author.ConnectDB(daoau);
		author.addAuthor();
		author.DisConnectDB();
		
		request.setAttribute("checkadd", 1);
		request.getRequestDispatcher("AddAuthor.jsp").forward(request, response);
		//doGet(request, response);
	}

}
