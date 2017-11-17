package BookModel;

import java.util.ArrayList;

import DAOInterface.BookInterface;

public class Book {
	private int idBook;
	private String name;
	private Author author;
	private Publisher publisher;
	private Discount discount;
	private long price;
	private String image;
	private String introduction;
	private int quantity;
	private String category;
	private BookInterface bookDao;

	public Book() {
		super();
	}

	public Book(int idBook, String name, Author author, Publisher publisher, Discount discount, long price,
			String image, String introduction, int quantity, String category) {
		super();
		this.idBook = idBook;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.discount = discount;
		this.price = price;
		this.image = image;
		this.introduction = introduction;
		this.quantity = quantity;
		this.category = category;
	}

	public Book(String name, Author author, Publisher publisher, Discount discount, long price, String image,
			String introduction, int quantity, String category) {
		super();
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.discount = discount;
		this.price = price;
		this.image = image;
		this.introduction = introduction;
		this.quantity = quantity;
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public void addBook() {
		this.bookDao.addObject(this);
	}

	public ArrayList<Book> searchBookByName() {
		return this.bookDao.searchBookByName(this.name);
	}

	public Book bookDetail() {
		return this.bookDao.bookDetail(this.idBook);
	}

	public boolean checkBookExist() {
		return this.bookDao.checkExist(this);
	}

	public ArrayList<Book> searchBookByIdNextLimited(int limit) {
		return this.bookDao.searchBookByIdNextLimited(this.idBook, limit);
	}

	public ArrayList<Book> searchBookByIdPreLimited(int limit) {
		return this.bookDao.searchBookByIdPreLimited(this.idBook, limit);
	}

	public int getLastID() {
		return this.bookDao.getLastID();
	}

	public int getFirstID() {
		return this.bookDao.getFirstID();
	}

	public int getNextId() {
		return this.bookDao.getNextId(idBook);
	}

	public int getpreId() {
		return this.bookDao.getPreId(idBook);
	}

	public void connectDB(BookInterface bookdao) {
		this.bookDao = bookdao;
		this.bookDao.Connect();
	}

	public void disconnectDB() {
		if (bookDao == null) {

		} else {
			this.bookDao.Disconnect();
		}
	}
}
