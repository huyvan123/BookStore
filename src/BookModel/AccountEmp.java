package BookModel;

public class AccountEmp extends Account {
	private String position;
	private String status;
	private String introduction;

	public AccountEmp(String position, String status, String introduction) {
		super();
		this.position = position;
		this.status = status;
		this.introduction = introduction;
	}

	public AccountEmp(String userName, String passWord, String position, String status, String introduction) {
		super(userName, passWord);
		this.position = position;
		this.status = status;
		this.introduction = introduction;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

}
