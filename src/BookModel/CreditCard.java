package BookModel;

import DAOInterface.CardInterface;

public class CreditCard {
	private int id;
	private String name;
	private String company;
	private String idCard;
	private long totalPrice;
	private CardInterface carddao;

	public CreditCard() {
		super();
	}

	public CreditCard(String name, String company, long totalPrice, String idcard) {
		super();
		this.name = name;
		this.company = company;
		this.totalPrice = totalPrice;
		this.idCard = idcard;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public boolean checkIdCard() {
		return this.carddao.checkExist(this);
	}
	
	public void connectDB(CardInterface card) {
		this.carddao = card;
		this.carddao.Connect();
	}
	
	public void disconnectDB() {
		if (carddao != null) {
			this.carddao.Disconnect();
		}
	}

}
