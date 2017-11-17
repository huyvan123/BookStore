package BookModel;

public class BookReview {
	private int id;
	private Book book;
	private ReaderReview reader;
	private EditorReview editer;
	private String note;

	public BookReview() {
		super();
	}

	public BookReview(Book book, ReaderReview reader, EditorReview editer, String note) {
		super();
		this.book = book;
		this.reader = reader;
		this.editer = editer;
		this.note = note;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public ReaderReview getReader() {
		return reader;
	}

	public void setReader(ReaderReview reader) {
		this.reader = reader;
	}

	public EditorReview getEditer() {
		return editer;
	}

	public void setEditer(EditorReview editer) {
		this.editer = editer;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
