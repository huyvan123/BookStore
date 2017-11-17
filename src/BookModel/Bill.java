package BookModel;

import java.sql.Date;

public class Bill {
	private int id;
	private Order order;
	private Employee emp;
	private String deliverName;
	private Date startDate;
	private Date endDate;
	private String note;

	public Bill() {
		super();
	}

	public Bill(Order order, Employee emp, String deliverName, Date startDate, Date endDate, String note) {
		super();
		this.order = order;
		this.emp = emp;
		this.deliverName = deliverName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.note = note;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public String getDeliverName() {
		return deliverName;
	}

	public void setDeliverName(String deliverName) {
		this.deliverName = deliverName;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
}
