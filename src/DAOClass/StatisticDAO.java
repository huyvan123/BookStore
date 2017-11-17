package DAOClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BookModel.Book;
import BookModel.Statistic;
import DAOInterface.StatisticInterface;

public class StatisticDAO implements StatisticInterface{
	private Connection connect;

	public StatisticDAO() {
		super();
	}

	@Override
	public void addObject(Statistic a) {
		String sql = "insert into bookstore.statistic(statistic.idBook,statistic.viewQuantity,statistic.perchaseQuantity)" + 
				" values (?,?,?)";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setInt(1, a.getBook().getIdBook());
			pre.setInt(2, a.getViewQuantity());
			pre.setInt(3, a.getPerchaseQuantity());
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteObject(Statistic a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateObject(Statistic a) {
		String sql = "update bookstore.statistic" + 
				" set statistic.viewQuantity = statistic.viewQuantity + ?, statistic.perchaseQuantity =statistic.perchaseQuantity + ?" + 
				" where statistic.idBook = ?";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setInt(1, a.getViewQuantity());
			pre.setInt(2, a.getPerchaseQuantity());
			pre.setInt(3, a.getBook().getIdBook());
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public int getLastID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean checkExist(Statistic a) {
		String sql = "select * from bookstore.statistic" + 
				" where statistic.idBook = ?";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setInt(1, a.getBook().getIdBook());
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

	@Override
	public ArrayList<Book> getListBookView(Statistic statis) {
		ArrayList<Book> listB = new ArrayList<>();
		String sql = "select * from bookstore.statistic,bookstore.book" + 
				" where book.ID = statistic.idBook and statistic.viewQuantity > 0" + 
				" order by statistic.viewQuantity desc limit 9";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				Book b = new Book();
				b.setIdBook(rs.getInt(2));
				b.setName(rs.getString(10));
				b.setPrice(rs.getLong(11));
				b.setImage(rs.getString(14));
				listB.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listB;
	}

	@Override
	public ArrayList<Book> getListBookPerchase(Statistic statis) {
		ArrayList<Book> listB = new ArrayList<>();
		String sql = "select * from bookstore.statistic,bookstore.book" + 
				" where book.ID = statistic.idBook and statistic.perchaseQuantity > 0" + 
				" order by statistic.perchaseQuantity desc limit 9";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				Book b = new Book();
				b.setIdBook(rs.getInt(2));
				b.setName(rs.getString(10));
				b.setPrice(rs.getLong(11));
				b.setImage(rs.getString(14));
				listB.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listB;
	}



}
