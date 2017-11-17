package DAOInterface;

import java.util.ArrayList;

import BookModel.Book;

public interface BookInterface extends DAOImp<Book> {
	ArrayList<Book> searchBookByName(String name);

	Book bookDetail(int idBook);

	ArrayList<Book> searchBookByIdNextLimited(int idstart, int limit);

	ArrayList<Book> searchBookByIdPreLimited(int idstart, int limit);
	
	int getNextId(int id);
	
	int getPreId(int id);
}
