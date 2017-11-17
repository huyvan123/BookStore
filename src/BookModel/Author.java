package BookModel;

import DAOInterface.AuthorInterface;

public class Author extends Person {

	private int idauthor;
	private String phoneNumber;
	private String email;
	private int exp;
	private String introduction;
	private AuthorInterface audao;

	public Author() {
		super();
	}

	public Author(Name name, Address address, DateOfBirth dob, String gender, int idauthor, String phoneNumber,
			String email, int exp, String introduction) {
		super(name, address, dob, gender);
		this.idauthor = idauthor;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.exp = exp;
		this.introduction = introduction;
	}
	

	public Author(Name name, Address address, DateOfBirth dob, String gender, String phoneNumber, String email, int exp,
			String introduction) {
		super(name, address, dob, gender);
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.exp = exp;
		this.introduction = introduction;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getIdauthor() {
		return idauthor;
	}

	public void setIdauthor(int idauthor) {
		this.idauthor = idauthor;
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

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public void addAuthor() {
		this.audao.addObject(this);
	}
	
	public boolean checkExist() {
		return this.audao.checkExist(this);
	}
	
	public void ConnectDB(AuthorInterface authorimp) {
		this.audao = authorimp;
		this.audao.Connect();
	}
	
	public void DisConnectDB() {
		if (this.audao != null) {
			this.audao.Disconnect();
		}
	}
}
