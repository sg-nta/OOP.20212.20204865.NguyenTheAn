package hust.soict.dsai.test.cart;
import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {
	public static void main (String[] args) throws LimitExceededException,IllegalArgumentException {
		//Create a new cart
		Cart cart = new Cart();
		
		//Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation","Roger Allers", 87, 19.95f);
		cart.addMedia(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction","George Lucas", 87, 24.95f);
		cart.addMedia(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		cart.addMedia(dvd3);
		cart.addMedia(dvd3);
		//Test the print method
		cart.print();
		
		//Test the search methods 
		cart.searchByID(1);
		cart.searchByID(5);
		cart.searchByTitle("no one at all");
		//Test the sort methods
		cart.sortByCost();
		cart.sortByTitle();
		
	}
}
