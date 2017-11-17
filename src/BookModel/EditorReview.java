package BookModel;

public class EditorReview {
	private int id;
	private Person person;
	private long phoneNumber;
	private String email;
	private String job;
	private int getScore;
	private String comment;

	public EditorReview(Person person, long phoneNumber, String email, String job, int getScore, String comment) {
		super();
		this.person = person;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.job = job;
		this.getScore = getScore;
		this.comment = comment;
	}

	public EditorReview() {
		super();
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getGetScore() {
		return getScore;
	}

	public void setGetScore(int getScore) {
		this.getScore = getScore;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
