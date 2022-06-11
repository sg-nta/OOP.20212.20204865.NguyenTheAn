package hust.soict.dsai.aims;
import java.util.*;

import hust.soict.dsai.aims.media.Media ;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
public class Aims {
	public static void main(String[] args) {
		Store store = new Store();
		Cart cart = new Cart();
		Thread a = new Thread(new MemoryDaemon());
		//a.setDaemon(true);
		a.start();

		showMenu(store, cart);

		while (true) {
			Scanner choose = new Scanner(System.in);
			int choosen = choose.nextInt();
			if (choosen == 1) {
				storeMenu(store, cart);
			}
			else if (choosen == 2) {
				updateStore(store, cart);
			}
			else if (choosen == 3) {
				cartMenu(store, cart);
			}
			else {
				System.out.println("Goodbye, see you again");
				break;
			}
		}



	}
	public static void showMenu(Store store, Cart cart) {
		System.out.println("AIMS: ");
		System.out.println("-----------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("-----------------------------");
		System.out.println("Please choose a number: 0-1-2-3");

	}
	public static void storeMenu(Store store, Cart cart) {
		System.out.println("Options: ");
		System.out.println("-----------------------------");
		System.out.println("1. See a media's details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. See current cart");
		System.out.println("0. Back");
		System.out.println("-----------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		Scanner choose = new Scanner(System.in);
		int choosen = choose.nextInt();
		if (choosen == 1) {
			System.out.println("Enter title of media you want to see: ");
			Scanner title = new Scanner(System.in);
			String titleString = title.next();
			store.viewDetails(titleString);
			System.out.println("Do you want to play this media? (y/n)");
			Scanner play = new Scanner(System.in);
			String playString = play.next();
			if (playString.equals("y")) {
				store.playMedia(titleString);
			}
			storeMenu(store,cart);
		}
		else if (choosen == 2) {
			store.print();
			System.out.println("Enter the title of DVD you want to add to cart");
			Scanner title = new Scanner(System.in);
			String titleString = title.next();
			Media media = store.getMediaByTitle(titleString);
			cart.addMedia(media);
			storeMenu(store,cart);
		}
		else if (choosen == 3) {
			cartMenu(store, cart);
		}
		else {
			showMenu(store, cart);
		
		}

	}
	public static void cartMenu(Store store, Cart cart) {
		System.out.println("Options: ");
		System.out.println("-----------------------------");
		System.out.println("1. Filter media in cart");
		System.out.println("2. Sort media in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media in cart");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("-----------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		Scanner choose = new Scanner(System.in);
		int choosen = choose.nextInt();
		if(choosen == 1) {
			filterMedia(store, cart);
		}
		else if (choosen == 2) {
			sortMedia(store, cart);
		}
		else if (choosen == 3) {
			System.out.println("Enter the title of the media you want to remove ");
			Scanner inp = new Scanner(System.in);
			String title = inp.next();
			Media media = new DigitalVideoDisc(title);
			cart.removeMedia(media);
			cartMenu(store,cart);
		}
		else if (choosen == 4) {
			cart.toString();
			System.out.println("Enter the title of the media you want to play ");
			Scanner inp = new Scanner(System.in);
			String title = inp.next();
			cart.playMedia(title);
		}
		else if (choosen == 5) {
			System.out.println("An order is created!");
			Media lucky = cart.getALuckyItem();
			if (lucky != null) {
				System.out.println("You got a lucky item " + lucky.getTitle());
				System.out.println("Your cart has been updated! ");
				cart.print();
				System.out.println("Lucky item: - " + lucky.getCost());
				System.out.println("Total cost: " + cart.getTotalCost());
			}
			cart.emptyCart();
			showMenu(store, cart);
		}
		else {
			showMenu(store, cart);
		}
	}
	public static void updateStore(Store store, Cart cart) {
		System.out.println("Options: ");
		System.out.println("-----------------------------");
		System.out.println("1. Add a media to store");
		System.out.println("2. Remove a media from store");
		System.out.println("0. Back");
		System.out.println("-----------------------------");
		System.out.println("Please choose a number: 0-1-2");
		Scanner choose = new Scanner(System.in);
		int choosen = choose.nextInt();
		if (choosen == 1) {
			addDVD(store,cart);
		}
		else if (choosen == 2) {
			store.print();
			System.out.println("Enter the title of DVD you want to remove");
			Scanner inp = new Scanner(System.in);
			String title = inp.next();
			Media media = new DigitalVideoDisc(title);
			store.removeMedia(media);
			updateStore(store,cart);
		}
		else {
			showMenu(store,cart);
		}
	}	
	
	public static void filterMedia(Store store, Cart cart) {
		System.out.println("Options: ");
		System.out.println("-----------------------------");
		System.out.println("1. Filter meidas by ID");
		System.out.println("2. Filter medias by Title");
		System.out.println("0. Back");
		System.out.println("-----------------------------");
		System.out.println("Please choose a number: 0-1-2");
		Scanner choose = new Scanner(System.in);
		int choosen = choose.nextInt();
		if(choosen == 1) {
			System.out.println("Enter ID: ");
			try {
				Scanner inp = new Scanner(System.in);
				int id = inp.nextInt();
				cart.searchByID(id);
			}catch(InputMismatchException id) {
				System.out.println("ID must be int");
			}finally {
				filterMedia(store,cart);
			}
		}
		else if(choosen == 2) {
			System.out.println("Enter Title: ");
			Scanner inp = new Scanner(System.in);
			String title = inp.next();
			cart.searchByTitle(title);
			filterMedia(store,cart);
		}
		else {
			cartMenu(store,cart);
		}
}
	public static void sortMedia(Store store, Cart cart) {
		System.out.println("Options: ");
		System.out.println("-----------------------------");
		System.out.println("1. Sort DVDs by Cost");
		System.out.println("2. Sort DVDs by Title");
		System.out.println("0. Back");
		System.out.println("-----------------------------");
		System.out.println("Please choose a number: 0-1-2");
		Scanner choose = new Scanner(System.in);
		int choosen = choose.nextInt();
		if(choosen == 1) {
			cart.sortByCost();
			sortMedia(store,cart);
		}
		else if(choosen == 2) {
			cart.sortByTitle();
			sortMedia(store,cart);
		}
		else {
			cartMenu(store,cart);
		}
	}
	public static void addDVD(Store store, Cart cart) {
		System.out.println("Options: ");
		System.out.println("-----------------------------");
		System.out.println("1. Add a DVD with title");
		System.out.println("2. Add a DVD with title, category, cost ");
		System.out.println("3. Add a DVD with title, category, director, cost ");
		System.out.println("4. Add a DVD with title, category, director, length, cost ");
		System.out.println("0. Back");
		System.out.println("-----------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		Scanner choose = new Scanner(System.in);
		int choosen = choose.nextInt();
		if (choosen == 1) {
			System.out.println("Enter the title: ");
			Scanner inp = new Scanner(System.in);
			String title = inp.next();
			DigitalVideoDisc dvd = new DigitalVideoDisc(title);
			store.addMedia(dvd);
			addDVD(store,cart);
		}
		else if (choosen == 2) {
			System.out.println("Enter the title, category, cost (seperated by space): ");
			try {
				Scanner inp = new Scanner(System.in);
				String title = inp.next();
				String category = inp.next();
				float cost = inp.nextFloat();
	
				DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost);
				store.addMedia(dvd);
			} catch (InputMismatchException cost) {
				System.out.println("The cost must be in float type");
			}finally {
			addDVD(store,cart);
			}
		}
		else if (choosen == 3) {
			System.out.println("Enter the title, category, director, cost (seperated by space): ");
			try {
				Scanner inp = new Scanner(System.in);
				String title = inp.next();
				String category = inp.next();
				String director = inp.next();
				float cost = inp.nextFloat();
	
				DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, cost);
				store.addMedia(dvd);
			} catch (InputMismatchException cost) {
				System.out.println("The cost must be in float type");
			}finally {
			addDVD(store,cart);
			}

		}
		else if (choosen == 4) {
			System.out.println("Enter the title, category, director, length, cost (seperated by space): ");
			Scanner inp = new Scanner(System.in);
			String title = inp.next();
			String category = inp.next();
			String director = inp.next();
			try {
				int length = inp.nextInt();
				try {
					float cost = inp.nextFloat();
					DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
					store.addMedia(dvd);
				}
				catch (InputMismatchException cost) {
					System.out.println("The cost must be in float type");
				}
			} catch (InputMismatchException length) {
				System.out.println("The length must be in int type");
			}finally {
				addDVD(store,cart);
			}
		}
		else {
			updateStore(store, cart);
		}
		
	}

}
