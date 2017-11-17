package BookModel;

import java.sql.Date;

import DAOInterface.DiscountInterface;

public class Discount {
	private int id;
	private String name;
	private int discountPercent;
	private String note;
	private Date startDate;
	private Date endDate;
	private DiscountInterface disdao;

	public Discount() {
		super();
	}

	public Discount(String name, int discountPercent, String note, Date startDate, Date endDate) {
		super();
		this.name = name;
		this.discountPercent = discountPercent;
		this.note = note;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Discount(int id, String name, int discountPercent, String note, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.name = name;
		this.discountPercent = discountPercent;
		this.note = note;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void addDiscount() {
		this.disdao.addObject(this);
	}
	
	public boolean checkDiscount() {
		return this.disdao.checkExist(this);
	}
	
	public void connectDB(DiscountInterface dao) {
		this.disdao = dao;
		this.disdao.Connect();
	}
	
	public void disconnectDB() {
		this.disdao.Disconnect();
	}
}
