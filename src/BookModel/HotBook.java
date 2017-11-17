package BookModel;

import java.util.ArrayList;

public class HotBook {
	private int id;
	private String category;
	private ArrayList<Book> listHot;

	public HotBook(int id, String category, ArrayList<Book> listHot) {
		super();
		this.id = id;
		this.category = category;
		this.listHot = listHot;
	}

	public HotBook(String category, ArrayList<Book> listHot) {
		super();
		this.category = category;
		this.listHot = listHot;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public ArrayList<Book> getListHot() {
		return listHot;
	}

	public void setListHot(ArrayList<Book> listHot) {
		this.listHot = listHot;
	}

}
