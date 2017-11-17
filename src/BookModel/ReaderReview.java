package BookModel;

import java.sql.Date;

public class ReaderReview {
	private int id;
	private Customer customer;
	private String comment;
	private Date time;

	public ReaderReview(Customer customer, String comment, Date time) {
		super();
		this.customer = customer;
		this.comment = comment;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
