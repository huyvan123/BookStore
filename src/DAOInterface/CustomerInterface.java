package DAOInterface;

import java.util.ArrayList;

import BookModel.Book;
import BookModel.Customer;

public interface CustomerInterface extends DAOImp<Customer>{
	public boolean checkLogin(Customer cus);
	public Customer findCusByUserName(String name);
	public int getIdPerson();
	public int getIdAccount();
	public ArrayList<Book> getListBookOfCus(Customer cus);
	public ArrayList<Integer> getListIdCartFromIdCus(int idcus);
}
