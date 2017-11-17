package DAOClass;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DAOConnect {

	private String name;
	private String url;
	private String dbClass;
	private Connection con;

	public DAOConnect() {
		super();
		name = "bookstore";
		url = "jdbc:mysql://localhost:3306/" + name;
		dbClass = "com.mysql.jdbc.Driver";
		try {
			Class.forName(dbClass);
			con =  DriverManager.getConnection(url,"root","van123");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Connection getConnect() {
		return con;
	}

}
