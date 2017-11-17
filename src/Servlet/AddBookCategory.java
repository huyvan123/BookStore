package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClass.DAOConnect;

/**
 * Servlet implementation class AddBookCategory
 */
@WebServlet("/AddBookCategory")
public class AddBookCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookCategory() {
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
		if(this.checkExist(name)) {
			request.setAttribute("checkadd", 0);
		}else {
			this.addObject(name);
			request.setAttribute("checkadd", 1);
		}
		request.getRequestDispatcher("AddBookCategory.jsp").forward(request, response);
		//doGet(request, response);
	}
	
	private boolean checkExist(String name) {
		Connection conect = new DAOConnect().getConnect();
		String check = "select * " + 
				" from bookstore.bookcategory" + 
				" where bookcategory.name = ?";
		try {
			PreparedStatement pre = conect.prepareStatement(check);
			pre.setString(1, name);
			ResultSet res = pre.executeQuery();
			while(res.next())return true;
			conect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	private void addObject(String name) {
		Connection conect = new DAOConnect().getConnect();
		String add = "insert into bookstore.bookcategory(bookcategory.name)" + 
				" value (?)";
		try {
			PreparedStatement pre = conect.prepareStatement(add);
			pre.setString(1, name);
			pre.executeUpdate();
			conect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
