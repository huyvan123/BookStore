package BookModel;

import DAOInterface.PublisherInterface;

public class Publisher {

	private int idPublisher;
	private Address address;
	private String name;
	private String phoneNumber;
	private String introduction;
	private String webSite;
	private int rank;
	private String email;
	private PublisherInterface pudao;

	public Publisher() {
		super();
	}

	public Publisher(int idPublisher, Address address, String name, String phoneNumber, String introduction,
			String webSite, int rank, String email) {
		super();
		this.idPublisher = idPublisher;
		this.address = address;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.introduction = introduction;
		this.webSite = webSite;
		this.rank = rank;
		this.email = email;
	}
	

	public Publisher(Address address, String name, String phoneNumber, String introduction, String webSite, int rank,
			String email) {
		super();
		this.address = address;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.introduction = introduction;
		this.webSite = webSite;
		this.rank = rank;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public int getIdPublisher() {
		return idPublisher;
	}

	public void setIdPublisher(int idPublisher) {
		this.idPublisher = idPublisher;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void addPublisher() {
		this.pudao.addObject(this);
	}
	
	public void connectDB(PublisherInterface publisher) {
		this.pudao = publisher;
		this.pudao.Connect();
	}
	
	public void disconnectDB() {
		if (pudao != null) {
			this.pudao.Disconnect();
		}
	}
}
