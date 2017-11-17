package DAOClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import BookModel.Author;
import DAOInterface.AuthorInterface;

public class AuthorDAO implements AuthorInterface {

	private Connection connect;

	public AuthorDAO() {
		super();
	}

	@Override
	public void addObject(Author author) {
		String sqlper = "insert into bookstore.person(person.name,person.address,person.dateOfBirth,person.age,person.gender)"
				+ " value (?,?,?,?,?)";
		try {
			PreparedStatement pre = connect.prepareStatement(sqlper);
			pre.setString(1, author.getName().getFullName());
			pre.setString(2, author.getAddress().getFullAddress());
			pre.setDate(3, author.getAge().getFullDOB());
			pre.setInt(4, author.getAge().getAge());
			pre.setString(5, author.getGender());
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql = "insert into bookstore.author(author.idPerson,author.exp,author.phoneNumber,author.email,author.introduction)"
				+ " value (?,?,?,?,?)";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setInt(1, this.getLastIdPerson());
			pre.setInt(2, author.getExp());
			pre.setString(3, author.getPhoneNumber());
			pre.setString(4, author.getEmail());
			pre.setString(5, author.getIntroduction());
			pre.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteObject(Author a) {
		String sql = "delete from bookstore.author" + " where author.ID = ?";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setInt(1, a.getIdauthor());
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateObject(Author a) {
		String sql = "update bookstore.person"
				+ " set person.age = ?, person.name = ?, person.address = ?, person.dateOfBirth = ?,person.gender = ?"
				+ "    where person.ID = ?";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setInt(1, a.getAge().getAge());
			pre.setString(2, a.getName().getFullName());
			pre.setString(3, a.getAddress().getFullAddress());
			pre.setDate(4, a.getAge().getFullDOB());
			pre.setString(5, a.getGender());
			pre.setInt(6, a.getIdPerson());
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
	public boolean checkExist(Author a) {
		String sql = "select * from bookstore.person"
				+ " where person.name = ? and person.gender = ? and person.address = ?" + " and person.dateOfBirth = ?";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setString(1, a.getName().getFullName());
			pre.setString(2, a.getGender());
			pre.setString(3, a.getAddress().getFullAddress());
			pre.setDate(4, a.getAge().getFullDOB());
			ResultSet rs = pre.executeQuery();
			while (rs.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int getLastIdPerson() {
		String sql = "SELECT MAX(person.ID)" + " FROM bookstore.person";
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
