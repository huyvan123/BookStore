package DAOClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BookModel.Account;
import BookModel.Address;
import BookModel.Book;
import BookModel.Customer;
import BookModel.DateOfBirth;
import BookModel.Name;
import DAOInterface.CustomerInterface;


public class CustomerNormalDAO implements CustomerInterface {

	private Connection connect;

	public CustomerNormalDAO() {
		super();
		
	}

	@Override
	public void addObject(Customer cus) {
		String sqlper = "insert into bookstore.person(person.name,person.address,person.dateOfBirth,person.age,person.gender)" + 
				" value (?,?,?,?,?)";
		try {
			PreparedStatement pre = connect.prepareStatement(sqlper);
			pre.setString(1, cus.getName().getFullName());
			pre.setString(2, cus.getAddress().getFullAddress());
			pre.setDate(3, cus.getAge().getFullDOB());
			pre.setInt(4, cus.getAge().getAge());
			pre.setString(5, cus.getGender());
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sqlacc = "insert into bookstore.accountcus(accountcus.userName,accountcus.passWord)" + 
				" value (?,?)";
			try {
				PreparedStatement pre = connect.prepareStatement(sqlacc);
				pre.setString(1, cus.getAccount().getUserName());
				pre.setString(2, cus.getAccount().getPassWord());
				pre.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		String sql = "insert into bookstore.customer(customer.idPerson,customer.idAccount,customer.phoneNumber,customer.email,customer.note,customer.category,customer.discountPercent)" + 
				" value (?,?,?,?,?,?,?)"; 
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setInt(1, this.getIdPerson());
			pre.setInt(2, this.getIdAccount());
			pre.setString(3, cus.getPhoneNumber());
			pre.setString(4, cus.getEmail());
			pre.setString(5, cus.getNote());
			pre.setString(6, cus.getCategory());
			pre.setInt(7, cus.getDiscountPercent());
			pre.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteObject(Customer a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateObject(Customer a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLastID() {
		return 0;
	}
//check sign up
	@Override
	public boolean checkExist(Customer a) {
		Customer cus = (Customer) a;
		String sql = "SELECT *" + 
				" FROM bookstore.customer,bookstore.accountcus" + 
				"		WHERE customer.idAccount = accountcus.ID" + 
				"        and accountcus.userName = ?";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setString(1, cus.getAccount().getUserName());
			ResultSet res = pre.executeQuery();
			while(res.next())return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean checkLogin(Customer cus) {
		String sql = "SELECT *" + 
				" FROM bookstore.customer,bookstore.accountcus" + 
				"		WHERE customer.idAccount = accountcus.ID " + 
				"        and accountcus.userName = ? and accountcus.passWord = ?";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setString(1, cus.getAccount().getUserName());
			pre.setString(2, cus.getAccount().getPassWord());
			ResultSet res = pre.executeQuery();
			while(res.next())return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public Customer findCusByUserName(String name) {
		Customer cus = null;
		String sql = "SELECT *" + 
				" FROM bookstore.customer,bookstore.accountcus,bookstore.person" + 
				"		WHERE customer.idAccount = accountcus.ID and customer.idPerson = person.ID" + 
				"        and accountcus.userName = ?";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setString(1, name);
			ResultSet res = pre.executeQuery();
			while(res.next()) {
				Name cusname = new Name();cusname.setFullName(res.getString(15));
				DateOfBirth dob = new DateOfBirth();dob.setFullDOB(res.getDate(14));
				Address address = new Address();address.setFullAddress(res.getString(13));
				Account account = new Account(res.getString(10), res.getString(11));
				cus = new Customer(cusname, address, dob, res.getString(17), res.getInt(1), account, res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getInt(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cus;
	}
	@Override
	public int getIdPerson() {
		String sql = "SELECT MAX(person.ID)" + 
				" FROM bookstore.person";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			ResultSet res = pre.executeQuery();
			while(res.next()) {
			return res.getInt(1);
			}
		} catch (SQLException e) {
		}
		return 0;
	}
	@Override
	public int getIdAccount() {
		String sql = "SELECT MAX(accountcus.ID)" + 
				" FROM bookstore.accountcus";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			ResultSet res = pre.executeQuery();
			while(res.next()) {
			return res.getInt(1);
			}
		} catch (SQLException e) {
		}
		return 0;
	}
	@Override
	public ArrayList<Book> getListBookOfCus(Customer cus) {
		ArrayList<Book> listBook = new ArrayList<>();
		String sql = "select cart.idBook" + 
				" from bookstore.cart" + 
				" where cart.idCustomer = ?";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setInt(1, cus.getIdCustomer());
			ResultSet res = pre.executeQuery();
			Book b = new Book();
			while(res.next()) {
				BookNormalDAO bdao = new BookNormalDAO();
				b.connectDB(bdao);
				b.setIdBook(res.getInt(1));
				b = b.bookDetail();
				listBook.add(b);
				b.disconnectDB();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listBook;
	}
	@Override
	public ArrayList<Integer> getListIdCartFromIdCus(int idcus){
		ArrayList<Integer> list = new ArrayList<>();
		String sql = "Select cart.ID" + 
				"	from bookstore.cart" + 
				"	where cart.idCustomer = ?";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setInt(1, idcus);
			ResultSet res = pre.executeQuery();
			while(res.next()) {
				list.add(res.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getFirstID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void Connect() {
		connect = new DAOConnect().getConnect();
		
	}

	@Override
	public void Disconnect() {
		try {
			this.connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
