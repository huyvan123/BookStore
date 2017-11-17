package BookModel;

public class Employee extends Person {
	private int id;
	private AccountEmp account;
	private String position;
	private String phoneNumber;
	private String email;
	private String introduction;

	public Employee() {
		super();
	}

	public Employee(AccountEmp account, String position, String phoneNumber, String email, String introduction) {
		super();
		this.account = account;
		this.position = position;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.introduction = introduction;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AccountEmp getAccount() {
		return account;
	}

	public void setAccount(AccountEmp account) {
		this.account = account;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
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

}
