package DAOInterface;

import java.util.ArrayList;

import BookModel.Book;
import BookModel.Statistic;

public interface StatisticInterface extends DAOImp<Statistic>{
	ArrayList<Book> getListBookView(Statistic statis);
	ArrayList<Book> getListBookPerchase(Statistic statis);
}
