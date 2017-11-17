package DAOInterface;

import BookModel.Author;

public interface AuthorInterface extends DAOImp<Author>{
	public int getLastIdPerson();
}
