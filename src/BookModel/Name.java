package BookModel;

public class Name {
	private String fisrtName;
	private String secondName;
	private String lastName;
	private String fullName;

	public Name() {
		super();
		this.fisrtName = "";
		this.secondName = "";
		this.lastName = "";
		this.fullName = "";
	}

	public Name(String fisrtName, String secondName, String lastName) {
		super();
		this.fisrtName = fisrtName;
		this.secondName = secondName;
		this.lastName = lastName;
		if (this.lastName == null && this.secondName == null) {
			this.fullName = this.fisrtName;
		} else if (this.secondName == null) {
			this.fullName = this.lastName + " " + this.fisrtName;
		} else
			this.fullName = this.lastName + " " + this.secondName + " " + this.fisrtName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFisrtName() {
		return fisrtName;
	}

	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return this.fullName;
	}

}
