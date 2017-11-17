package DAOClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BookModel.Book;
import BookModel.Cart;
import BookModel.Customer;
import DAOInterface.CartInterface;

public class CartDAO implements CartInterface {

	private Connection connect;

	public CartDAO() {
		super();

	}

	@Override
	public void addObject(Cart cart) {
		String sql = "insert into bookstore.cart(cart.idBook,cart.idCustomer,cart.quantity)" + "value (?,?,?)";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setInt(1, cart.getBook().getIdBook());
			pre.setInt(2, cart.getCustomer().getIdCustomer());
			pre.setInt(3, cart.getBookquantity());
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteObject(Cart cart) {
		String sql = "delete from bookstore.cart" + " where cart.ID = ?";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setInt(1, cart.getIdCart());
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateObject(Cart a) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getLastID() {
		String sql = "SELECT MAX(cart.idcart)" + " FROM bookstore.cart";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			ResultSet res = pre.executeQuery();
			while (res.next()) {
				return res.getInt(1);
			}
		} catch (SQLException e) {
		}
		return 0;
	}

	@Override
	public boolean checkExist(Cart a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getItemQuantity(Cart cart) {
		String sql = "select count(cart.ID)" + "	from bookstore.cart" + "	where cart.idCustomer = ?";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setInt(1, cart.getCustomer().getIdCustomer());
			ResultSet res = pre.executeQuery();
			while (res.next()) {
				return res.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int getIdCart(Cart cart) {
		String sql = "select cart.ID from bookstore.cart" + " where cart.idbook = ? and cart.idcustomer = ?";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setInt(1, cart.getBook().getIdBook());
			pre.setInt(2, cart.getCustomer().getIdCustomer());
			ResultSet res = pre.executeQuery();
			while (res.next()) {
				return res.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void updateQuantity(Cart cart, int number) {
		String sql = "update bookstore.cart" + "	set cart.quantity = cart.quantity + ?" + "	where cart.ID = ?";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setInt(1, number);
			pre.setInt(2, cart.getIdCart());
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

	@Override
	public ArrayList<Cart> getCartByUserName(Cart cart) {
		ArrayList<Cart> list = new ArrayList<>();
		String sql  = "select * from bookstore.cart" + 
				" where cart.idCustomer = ? ";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setInt(1, cart.getCustomer().getIdCustomer());
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				Customer cus = new Customer();
				cus.setIdCustomer(rs.getInt(2));
				Book b = new Book();b.setIdBook(rs.getInt(3));
				Cart c = new Cart(rs.getInt(1), cus, rs.getInt(4), b);
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  list;
	}

}
