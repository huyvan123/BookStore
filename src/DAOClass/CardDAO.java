package DAOClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import BookModel.CreditCard;
import DAOInterface.CardInterface;

public class CardDAO implements CardInterface {
	private Connection connect;

	public CardDAO() {
		super();
	}

	@Override
	public void addObject(CreditCard a) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteObject(CreditCard a) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateObject(CreditCard a) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getLastID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean checkExist(CreditCard card) {
		String sql = "select *" + 
				" from bookstore.creditcard" + 
				" where creditcard.idcard = ? ";
		try {
			PreparedStatement pre =connect.prepareStatement(sql);
			pre.setString(1, card.getIdCard());
			ResultSet res = pre.executeQuery();
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
