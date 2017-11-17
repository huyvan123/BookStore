package BookModel;

import DAOInterface.StatisticInterface;

public class Statistic {
	private int idStatistic;
	private Book book;
	private int viewQuantity;
	private int perchaseQuantity;
	private StatisticInterface stadao;

	public Statistic() {
		super();
	}

	public Statistic(Book book, int viewQuantity, int perchaseQuantity) {
		super();
		this.book = book;
		this.viewQuantity = viewQuantity;
		this.perchaseQuantity = perchaseQuantity;
	}

	public int getIdStatistic() {
		return idStatistic;
	}

	public void setIdStatistic(int idStatistic) {
		this.idStatistic = idStatistic;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getViewQuantity() {
		return viewQuantity;
	}

	public void setViewQuantity(int viewQuantity) {
		this.viewQuantity = viewQuantity;
	}

	public int getPerchaseQuantity() {
		return perchaseQuantity;
	}

	public void setPerchaseQuantity(int perchaseQuantity) {
		this.perchaseQuantity = perchaseQuantity;
	}

	public StatisticInterface getStadao() {
		return stadao;
	}

	public void setStadao(StatisticInterface stadao) {
		this.stadao = stadao;
	}
	
	public void connectDB(StatisticInterface st) {
		this.stadao = st;
		this.stadao.Connect();
	}
	
	public void disconnectDB() {
		if (stadao == null) {

		} else {
			this.stadao.Disconnect();
		}
	}
}
