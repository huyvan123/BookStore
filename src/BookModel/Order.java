package BookModel;

import DAOInterface.OrderInterface;

public class Order {
	private int idOrder;
	private Address destination;
	private Customer customer;
	private Cart cart;
	private String paymentType;
	private CreditCard card;
	private String status;
	private String note;
	private OrderInterface orderdao;

	public Order() {
		super();
	}

	public Order(Address destination, Customer customer, String paymentType, Cart cart) {
		super();
		this.destination = destination;
		this.customer = customer;
		this.paymentType = paymentType;
		this.cart = cart;
	}

	public Order(Address destination, Customer customer, String paymentType, CreditCard card, Cart cart) {
		super();
		this.destination = destination;
		this.customer = customer;
		this.paymentType = paymentType;
		this.card = card;
		this.cart = cart;
	}

	public Order(Address destination, Customer customer, String paymentType, CreditCard card, String status,
			String note) {
		super();
		this.destination = destination;
		this.customer = customer;
		this.paymentType = paymentType;
		this.card = card;
		this.status = status;
		this.note = note;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public CreditCard getCard() {
		return card;
	}

	public void setCard(CreditCard card) {
		this.card = card;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public Address getDestination() {
		return destination;
	}

	public void setDestination(Address destination) {
		this.destination = destination;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public OrderInterface getOrderdao() {
		return orderdao;
	}

	public void setOrderdao(OrderInterface orderdao) {
		this.orderdao = orderdao;
	}

	public void addOrder() {
		this.orderdao.addObject(this);
	}

	public void connectDB(OrderInterface order) {
		this.orderdao = order;
		this.orderdao.Connect();
	}

	public void disconnectDB() {
		if (orderdao != null) {
			this.orderdao.Disconnect();
		}
	}
}
