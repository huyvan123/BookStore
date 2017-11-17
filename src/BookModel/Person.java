package BookModel;

public class Person {

	protected int idPerson;
	protected Name name;
	protected Address address;
	protected DateOfBirth dob;
	protected String gender;

	public Person() {
		super();
	}

	public Person(Name name, Address address, DateOfBirth dob, String gender) {
		super();
		this.name = name;
		this.address = address;
		this.dob = dob;
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public DateOfBirth getAge() {
		return dob;
	}

	public void setAge(DateOfBirth dob) {
		this.dob = dob;
	}

}
