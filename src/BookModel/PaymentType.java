package BookModel;

public class PaymentType {
	private int id;
	private CreditCard card;
	private String name;
	private String note;

	public PaymentType() {
		super();
	}

	public PaymentType(CreditCard card, String name, String note) {
		super();
		this.card = card;
		this.name = name;
		this.note = note;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CreditCard getCard() {
		return card;
	}

	public void setCard(CreditCard card) {
		this.card = card;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
