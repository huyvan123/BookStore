package DAOInterface;

import java.util.ArrayList;

import BookModel.Cart;

public interface CartInterface extends DAOImp<Cart> {
	int getIdCart(Cart cart);

	void updateQuantity(Cart cart, int number);

	int getItemQuantity(Cart cart);
	
	ArrayList<Cart> getCartByUserName(Cart cart);
	
}
