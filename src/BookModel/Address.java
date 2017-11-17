package BookModel;

public class Address {
	private String country;
	private String city;
	private String district;
	private String street;
	private String lane;// ngõ
	private String no;
	private String fullAddress;

	public Address() {
		super();
		this.city = "";
		this.country = "";
		this.district = "";
		this.street = "";
		this.lane = "";
		this.no = "";
		this.fullAddress = "";
	}
	
	public Address(String s) {
		super();
		this.fullAddress = s;
	}

	public Address(String country, String city, String district, String street, String lane, String no) {
		super();
		this.country = country;
		this.city = city;
		this.district = district;
		this.street = street;
		this.lane = lane;
		this.no = no;
		if (this.city == null) {
			this.fullAddress = this.country;
		} else if (this.district == null) {
			this.fullAddress = this.city + ", " + this.country;
		} else
			this.fullAddress = this.no + ", " + this.lane + ", " + this.street + ", " + this.district + ", " + this.city
					+ ", " + this.country;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLane() {
		return lane;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

}
