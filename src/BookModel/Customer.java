package BookModel;

import java.util.ArrayList;
import java.util.List;

import DAOInterface.CustomerInterface;

public class Customer extends Person {
	private int idCustomer;
	private Account account;
	private String phoneNumber;
	private String email;
	private String note;
	private String category;
	private int discountPercent;
	private List<Book> listBook;
	private long totalprice;
	private CustomerInterface cusdao;

	public Customer() {
		super();
	}

	public Customer(Name name, Address address, DateOfBirth dob, String gender, int idCustomer, Account account,
			String phoneNumber, String email, String note, String category, int discountPercent) {
		super(name, address, dob, gender);
		this.idCustomer = idCustomer;
		this.account = account;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.note = note;
		this.category = category;
		this.discountPercent = discountPercent;
	}

	public Customer(Name name, Address address, DateOfBirth dob, String gender, Account account, String phoneNumber,
			String email, String note, String category, int discountPercent) {
		super(name, address, dob, gender);
		this.account = account;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.note = note;
		this.category = category;
		this.discountPercent = discountPercent;
	}

	public Customer(Name name, Address address, DateOfBirth dob, String gender, Account account, String phoneNumber,
			String email) {
		super(name, address, dob, gender);
		this.account = account;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public List<Book> getListBook() {
		return listBook;
	}

	public void setListBook(ArrayList<Book> listBook) {
		this.listBook = listBook;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getTotalPrice() {
		for (Book b : this.listBook) {
			try {
			this.totalprice = 0;
				long dis = b.getDiscount().getDiscountPercent();
				this.totalprice = (long) (b.getPrice() * b.getQuantity() - dis * b.getPrice()*0.01);
			} catch (Exception e) {
				this.totalprice = b.getPrice() * b.getQuantity();
			}
		}
		return this.totalprice;
	}

	public void addCustomer() {
		this.cusdao.addObject(this);
	}

	public boolean checkSignUp() {
		return this.cusdao.checkExist(this);
	}

	public boolean checkLogin() {
		return this.cusdao.checkLogin(this);
	}

	public Customer findCustomerByUserName() {
		return this.cusdao.findCusByUserName(this.getAccount().getUserName());
	}

	public void getListBookOfCustomer() {
		this.listBook = new ArrayList<>();
		this.listBook = this.cusdao.getListBookOfCus(this);
	}

	public ArrayList<Integer> getListIdCartFromIdCus() {
		return this.cusdao.getListIdCartFromIdCus(this.idCustomer);
	}
	
	public void connectDB(CustomerInterface cusdao) {
		this.cusdao = cusdao;
		this.cusdao.Connect();
	}
	
	public void disconnect() {
		if (this.cusdao != null) {
			this.cusdao.Disconnect();
		}
	}
}
