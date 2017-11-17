package DAOClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import BookModel.Publisher;
import DAOInterface.PublisherInterface;

public class PublisherDAO implements PublisherInterface{

	private Connection connect;

	public PublisherDAO() {
		super();

	}

	@Override
	public void addObject(Publisher pu) {
		String sql = "insert into bookstore.company(company.address,company.phoneNumber,company.email,company.introduction,company.rank,company.website,company.name)" + 
				" value (?,?,?,?,?,?,?)"; 
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setString(1, pu.getAddress().getFullAddress());
			pre.setString(2, pu.getPhoneNumber());
			pre.setString(3, pu.getEmail());
			pre.setString(4, pu.getIntroduction());
			pre.setInt(5, pu.getRank());
			pre.setString(6, pu.getWebSite());
			pre.setString(7, pu.getName());
			pre.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteObject(Publisher a) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateObject(Publisher a) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getLastID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean checkExist(Publisher a) {
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

}
