package DAOClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import BookModel.Discount;
import DAOInterface.DiscountInterface;

public class DiscountDAO implements DiscountInterface {

	private Connection connect;

	public DiscountDAO() {
		super();
	}

	@Override
	public void addObject(Discount dis) {
		String sql = "insert into bookstore.discount(discount.name,discount.discountPercen,discount.startDate,discount.endDate,discount.note)" + 
				" value (?,?,?,?,?)";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setString(1, dis.getName());
			pre.setInt(2, dis.getDiscountPercent());
			pre.setDate(3, dis.getStartDate());
			pre.setDate(4, dis.getEndDate());
			pre.setString(5, dis.getNote());
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteObject(Discount a) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateObject(Discount a) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getLastID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean checkExist(Discount dis) {
		String sql = "select *" + 
				" from bookstore.discount" + 
				" where discount.name = ? and discount.discountPercen = ?" + 
				"	and discount.startDate = ? and discount.endDate = ?";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setString(1, dis.getName());
			pre.setInt(2, dis.getDiscountPercent());
			pre.setDate(3, dis.getStartDate());
			pre.setDate(4, dis.getEndDate());
			ResultSet res  = pre.executeQuery();
			while(res.next())return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

}
