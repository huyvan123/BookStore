package DAOClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BookModel.Address;
import BookModel.Author;
import BookModel.Book;
import BookModel.DateOfBirth;
import BookModel.Discount;
import BookModel.Name;
import BookModel.Publisher;
import DAOInterface.BookInterface;

public class BookNormalDAO implements BookInterface {

	private Connection connect;

	public BookNormalDAO() {
		super();
	}

	@Override
	public void addObject(Book book) {
		String sql = "insert into bookstore.book(book.idAuthor,book.idCompany,book.idDiscount,book.caregory,book.name,book.price,book.introduction,book.quantity,book.image)" + 
				" value(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setInt(1, book.getAuthor().getIdauthor());
			pre.setInt(2, book.getPublisher().getIdPublisher());
			pre.setInt(3, book.getDiscount().getId());
			pre.setString(4, book.getCategory());
			pre.setString(5, book.getName());
			pre.setLong(6, book.getPrice());
			pre.setString(7, book.getIntroduction());
			pre.setInt(8, book.getQuantity());
			pre.setString(9, book.getImage());
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteObject(Book a) {
		String sql = "delete from bookstore.book" + 
				" where book.ID = ?";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setInt(1, a.getIdBook());
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateObject(Book a) {
		String sql = "update bookstore.book" + 
				" set book.idAuthor = ?, book.idCompany = ?, book.idDiscount = ?, book.image = ?," + 
				"	book.name = ?, book.price = ?, book.quantity = ?, book.caregory = ?, book.introduction = ?" + 
				" where book.ID = ?";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setInt(1, a.getAuthor().getIdauthor());
			pre.setInt(2, a.getPublisher().getIdPublisher());
			pre.setInt(3, a.getDiscount().getId());
			pre.setString(4, a.getImage());
			pre.setString(5, a.getName());
			pre.setLong(6, a.getPrice());
			pre.setInt(7, a.getQuantity());
			pre.setString(8, a.getCategory());
			pre.setString(9, a.getIntroduction());
			pre.setInt(10, a.getIdBook());
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int getLastID() {
		String sql = "SELECT MAX(book.ID)" + 
					" FROM bookstore.book";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			ResultSet res = pre.executeQuery();
			while(res.next())
			return res.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1000;
	}

	@Override
	public boolean checkExist(Book a) {
		String sql = "select * from bookstore.book" + 
				" where book.idAuthor = ? and book.idCompany = ? and book.caregory = ?" + 
				"	and book.idDiscount = ? and book.name = ?";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setInt(1, a.getAuthor().getIdauthor());
			pre.setInt(2, a.getPublisher().getIdPublisher());
			pre.setString(3, a.getCategory());
			pre.setInt(4, a.getDiscount().getId());
			pre.setString(5, a.getName());
			ResultSet rs = pre.executeQuery();
			while(rs.next())return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

@Override
	public ArrayList<Book> searchBookByName(String name) {
		ArrayList<Book> listBook = new ArrayList<>();
		String sql = "SELECT *"
				+ " FROM bookstore.book"
				+ " WHERE book.name LIKE ?";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setString(1, "%"+name+ "%");
			ResultSet res = pre.executeQuery();
			while(res.next()) {
				Author au = new Author();au.setIdauthor(res.getInt(2));
				Publisher pu = new Publisher(); pu.setIdPublisher(res.getInt(3));
				Discount dis =  new Discount();dis.setId(res.getInt(4));
				Book book = new Book(res.getInt(1), res.getString(6), au, pu, dis, res.getLong(7), res.getString(10), res.getString(8), res.getInt(9), res.getString(5));
				listBook.add(book);
			}
		} catch (SQLException e) {
			//e.printStackTrace();
		}
		return listBook;
	}
	@Override
	public Book bookDetail(int idBook) {
		Book book = null;
		String sql = "select * " + 
				" from bookstore.book,bookstore.author,bookstore.person,bookstore.company,bookstore.discount" + 
				"	where person.ID = author.idPerson and book.idCompany = company.ID" + 
				"   and book.idAuthor = author.ID  and  book.ID = ? and discount.ID = book.idDiscount";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setInt(1, idBook);
			ResultSet res = pre.executeQuery();
			while(res.next()) {
				Name name = new Name();name.setFullName(res.getString(20));
				Address address = new Address();address.setFullAddress(res.getString(18));
				DateOfBirth dob = new DateOfBirth();dob.setFullDOB(res.getDate(19));
				Author author = new Author(name, address, dob, res.getString(22), res.getInt(2), res.getString(14), res.getString(15), res.getInt(13), res.getString(16));
				Address addpub = new Address();addpub.setFullAddress(res.getString(24));
				Publisher publisher = new Publisher(res.getInt(3), addpub, res.getString(25), res.getString(26), res.getString(29), res.getString(28), res.getInt(30),res.getString(27));
				Discount discount = new Discount(res.getInt(4), res.getString(32), res.getInt(33), res.getString(34),res.getDate(35),res.getDate(36));
				book = new Book(idBook, res.getString(6), author, publisher, discount, res.getLong(7), res.getString(10), res.getString(8), res.getInt(9),res.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public int getFirstID() {
		String sql = "SELECT min(book.ID)" + 
				" FROM bookstore.book";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			while(rs.next())return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<Book> searchBookByIdNextLimited(int idstart, int limit) {
		ArrayList<Book> listBook = new ArrayList<>();
		String sql = "SELECT *" + 
				"	FROM bookstore.book" + 
				"	where book.ID >= ? limit ?";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setInt(1, idstart);
			pre.setInt(2, limit);
			ResultSet res = pre.executeQuery();
			while(res.next()) {
				Author au = new Author();au.setIdauthor(res.getInt(2));
				Publisher pu = new Publisher(); pu.setIdPublisher(res.getInt(3));
				Discount dis =  new Discount();dis.setId(res.getInt(4));
				Book book = new Book(res.getInt(1), res.getString(6), au, pu, dis, res.getLong(7), res.getString(10), res.getString(8), res.getInt(9), res.getString(5));
				listBook.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listBook;
	}

	@Override
	public ArrayList<Book> searchBookByIdPreLimited(int idstart, int limit) {
		ArrayList<Book> listBook = new ArrayList<>();
		String sql = "SELECT *" + 
				"	FROM bookstore.book" + 
				"	where book.ID <= ? limit ?";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setInt(1, idstart);
			pre.setInt(2, limit);
			ResultSet res = pre.executeQuery();
			while(res.next()) {
				Author au = new Author();au.setIdauthor(res.getInt(2));
				Publisher pu = new Publisher(); pu.setIdPublisher(res.getInt(3));
				Discount dis =  new Discount();dis.setId(res.getInt(4));
				Book book = new Book(res.getInt(1), res.getString(6), au, pu, dis, res.getLong(7), res.getString(10), res.getString(8), res.getInt(9), res.getString(5));
				listBook.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listBook;
	}

	@Override
	public int getNextId(int id) {
		String sql = "SELECT book.ID" + 
				"		FROM bookstore.book" + 
				"		where book.ID > ? limit 1";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setInt(1, id);
			ResultSet rs = pre.executeQuery();
			while(rs.next())return rs.getInt(1);
		} catch (SQLException e) {
		}
		return 0;
	}

	@Override
	public int getPreId(int id) {
		String sql = "SELECT max(book.ID)" + 
				"		FROM bookstore.book" + 
				"		where book.ID < ?";
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setInt(1, id);
			ResultSet rs = pre.executeQuery();
			while(rs.next())return rs.getInt(1);
		} catch (SQLException e) {
		}
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
