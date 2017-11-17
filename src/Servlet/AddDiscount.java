package Servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BookModel.DateOfBirth;
import BookModel.Discount;
import DAOClass.DiscountDAO;

/**
 * Servlet implementation class AddDiscount
 */
@WebServlet("/AddDiscount")
public class AddDiscount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDiscount() {
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
		int percent = 0;
		try {
			percent = Integer.parseInt(request.getParameter("percent"));
		} catch (Exception e) {
		}
		Date start = new DateOfBirth(request.getParameter("startdate")).getFullDOB();
		Date end = new DateOfBirth(request.getParameter("enddate")).getFullDOB();
		String note = request.getParameter("note");
		Discount dis = new Discount(name, percent, note, start, end);
		if(dis.checkDiscount()) {
			request.setAttribute("checkadd", 0);
		}else {
			request.setAttribute("checkadd", 1);
			//add
			DiscountDAO disdao = new DiscountDAO();
			dis.connectDB(disdao);
			dis.addDiscount();
			dis.disconnectDB();
		}
		request.getRequestDispatcher("AddDiscount.jsp").forward(request, response);
		//doGet(request, response);
	}

}
