package hust.soict.dsai.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.screen.customer.controller.CartController;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CartScreen {
	private Cart cart;
	private Store store;
	public static void main(String[] args) {
		Cart cart = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation","Roger Allers", 87, 19.95f);
		cart.addMedia(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction","George Lucas", 87, 24.95f);
		cart.addMedia(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		cart.addMedia(dvd3);
		Store store = new Store();
		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(dvd3);
		new CartScreen(store,cart);
	}
	public CartScreen(Store store, Cart cart) {
		super();
		
		this.cart = cart;
		this.store = store;
		JFXPanel fxPanel = new JFXPanel();
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					final String CART_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Cart.fxml";
		    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
		    		fxmlLoader.setController(new CartController(store,cart));
		    		Parent root = fxmlLoader.load();
		    		Stage stage = new Stage();
		    		stage.setScene(new Scene(root));
		    		stage.setTitle("Cart");
		    		stage.show();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

}
