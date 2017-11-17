package DAOInterface;

import BookModel.Order;

public interface OrderInterface extends DAOImp<Order>{
	
	void addWithOutCard(Order order);

}
