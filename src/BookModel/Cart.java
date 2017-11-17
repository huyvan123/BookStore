package BookModel;

import DAOInterface.CartInterface;

public class Cart {
	private int idCart;
	private Customer customer;
	private int bookquantity;
	private Book book;
	private CartInterface cartdao;

	public Cart() {
		super();
	}

	public Cart(Customer customer, int bookquantity, Book book) {
		super();
		this.book = book;
		this.customer = customer;
		this.bookquantity = bookquantity;
	}

	public Cart(int idCart, Customer customer, int bookquantity, Book book) {
		super();
		this.idCart = idCart;
		this.customer = customer;
		this.bookquantity = bookquantity;
		this.book = book;
	}

	public CartInterface getCartdao() {
		return cartdao;
	}

	public void setCartdao(CartInterface cartdao) {
		this.cartdao = cartdao;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getBookquantity() {
		return bookquantity;
	}

	public void setBookquantity(int bookquantity) {
		this.bookquantity = bookquantity;
	}

	public int getIdCart() {
		return idCart;
	}

	public void setIdCart(int idCart) {
		this.idCart = idCart;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void addCart() {
		this.cartdao.addObject(this);
	}

	public int getItemQuantity() {
		return this.cartdao.getItemQuantity(this);
	}

	public void getIdCartFromCusAndBook() {
		this.idCart = this.cartdao.getIdCart(this);
	}

	public void updateQuantity(int number) {
		this.cartdao.updateQuantity(this, number);
	}

	public void deleteCart() {
		this.cartdao.deleteObject(this);
		;

	}

	public void connectDB(CartInterface cart) {
		this.cartdao = cart;
		this.cartdao.Connect();
	}

	public void disconnectDB() {
		if (this.cartdao != null) {
			this.cartdao.Disconnect();
		}
	}
}
