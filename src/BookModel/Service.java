package BookModel;

public class Service {
	private int id;
	private String name;
	private int quantity;
	private long price;
	private String introduction;
	private String category;

	public Service(String name, int quantity, long price, String introduction, String category) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.introduction = introduction;
		this.category = category;
	}

	public Service() {
		super();
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
