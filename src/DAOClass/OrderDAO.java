package DAOClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import BookModel.Order;
import DAOInterface.OrderInterface;

public class OrderDAO implements OrderInterface {
	private Connection connect;

	public OrderDAO() {
		super();
	}

	@Override
	public void addObject(Order order) {
		String sql = "insert into bookstore.bookorder(bookorder.idCustomer,bookorder.paymentType,bookorder.idCreditcard," + 
				"		bookorder.address,bookorder.status,bookorder.note,bookorder.idBook,bookorder.quantity)" + 
				"				 value (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setInt(1, order.getCustomer().getIdCustomer());
			pre.setString(2, order.getPaymentType());
			pre.setString(3, order.getCard().getIdCard());
			pre.setString(4, order.getDestination().getFullAddress());
			pre.setString(5, "Waiting");
			pre.setString(6, order.getNote());
			pre.setInt(7, order.getCart().getBook().getIdBook());
			pre.setInt(8, order.getCart().getItemQuantity());
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteObject(Order a) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateObject(Order a) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getLastID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean checkExist(Order a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getFirstID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void Connect() {
		this.connect = new DAOConnect().getConnect();
		
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
	public void addWithOutCard(Order order) {
		String sql = "insert into bookstore.bookorder(bookorder.idCustomer,bookorder.paymentType," + 
				"		bookorder.address,bookorder.status,bookorder.idBook,bookorder.quantity)" + 
				"				 values (?,?,?,?,?,?)";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			System.out.println("idcus: "+order.getCustomer().getIdCustomer());
			System.out.println("payment type: "+order.getPaymentType());
			System.out.println("adddress: "+order.getDestination().getFullAddress());
			System.out.println("status: "+order.getStatus());
			System.out.println("idbook: "+order.getCart().getBook().getIdBook());
			System.out.println("bookquantity: "+order.getCart().getBookquantity());
			pre.setInt(1, order.getCustomer().getIdCustomer());
			pre.setString(2, order.getPaymentType());
			pre.setString(3, order.getDestination().getFullAddress());
			pre.setString(4, "Waiting");
			pre.setInt(5, order.getCart().getBook().getIdBook());
			pre.setInt(6, order.getCart().getBookquantity());
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

}
