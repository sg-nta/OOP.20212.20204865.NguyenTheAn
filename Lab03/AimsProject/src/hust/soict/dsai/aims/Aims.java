package hust.soict.dsai.aims;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	public static void main(String[] args) {
		/* Previous lab
		Cart anOrder = new Cart();
		
		//Test method create DVD and method addDigitalVideoDisc
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation","Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction","George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		System.out.println("Total Cost is: " + anOrder.totalCost());
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("XYZ",
				"Animation", 40f);
		anOrder.addDigitalVideoDisc(dvd4);
		System.out.println("Total Cost is: " + anOrder.totalCost());
		
		//Test method removeDigitalVideoDisc
		anOrder.removeDigitalVideoDisc(dvd2);
		System.out.println("Total Cost is: " + anOrder.totalCost());
		anOrder.removeDigitalVideoDisc(dvd2);

		
		//Test method addDigitalVideoDisc for list of discs
		
		DigitalVideoDisc[] discArr = new DigitalVideoDisc[4];
		discArr[0] = new DigitalVideoDisc("Science fact","Science",20f);
		discArr[1] = new DigitalVideoDisc("Biology study","Biology",40f);
		discArr[2] = new DigitalVideoDisc("Math study","Math",25f);
		discArr[3] = new DigitalVideoDisc("Python tutorials","Programming",60f);
		anOrder.addDigitalVideoDisc(discArr);
		System.out.println("Total Cost is: " + anOrder.totalCost());
		*/
		Store store = new Store();
		Cart cart = new Cart();
		showMenu(store, cart);
		
		
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
			System.exit(0);
		}
	}
	public static void storeMenu(Store store, Cart cart) {
		System.out.println("Options: ");
		System.out.println("-----------------------------");
		System.out.println("1. See a DVD's details");
		System.out.println("2. Add a DVD to cart");
		System.out.println("3. See current cart");
		System.out.println("0. Back");
		System.out.println("-----------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		Scanner choose = new Scanner(System.in);
		int choosen = choose.nextInt();
		if (choosen == 1) {
			System.out.println("Enter title of DVD you want to see: ");
			Scanner title = new Scanner(System.in);
			String titleString = title.next();
			store.viewDetails(titleString);
			storeMenu(store,cart);
		}
		else if (choosen == 2) {
			store.print();
			System.out.println("Enter the title of DVD you want to add to cart");
			Scanner title = new Scanner(System.in);
			String titleString = title.next();
			DigitalVideoDisc disc = store.getDiscByTitle(titleString);
			cart.addDigitalVideoDisc(disc);
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
		System.out.println("1. Filter DVDs in cart");
		System.out.println("2. Sort DVDs in cart");
		System.out.println("3. Remove DVD from cart");
		System.out.println("4. Place order");
		System.out.println("0. Back");
		System.out.println("-----------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		Scanner choose = new Scanner(System.in);
		int choosen = choose.nextInt();
		if(choosen == 1) {
			filterDVD(store, cart);
			cartMenu(store,cart);
		}
		else if (choosen == 2) {
			sortDVD(store, cart);
			cartMenu(store,cart);
		}
		else if (choosen == 3) {
			System.out.println("Enter the title of the DVD you want to remove ");
			Scanner inp = new Scanner(System.in);
			String title = inp.next();
			DigitalVideoDisc dvd = new DigitalVideoDisc(title);
			cart.removeDigitalVideoDisc(dvd);
			cartMenu(store,cart);
		}
		else if (choosen == 4) {
			System.out.println("An order is created!");
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
		System.out.println("1. Add a DVD to store");
		System.out.println("2. Remove a DVD from store");
		System.out.println("0. Back");
		System.out.println("-----------------------------");
		System.out.println("Please choose a number: 0-1-2");
		Scanner choose = new Scanner(System.in);
		int choosen = choose.nextInt();
		if (choosen == 1) {
			addDVD(store,cart);
			updateStore(store,cart);
		}
		else if (choosen == 2) {
			store.print();
			System.out.println("Enter the title of DVD you want to remove");
			Scanner inp = new Scanner(System.in);
			String title = inp.next();
			store.removeDVD(title);
			updateStore(store,cart);
		}
		else {
			showMenu(store,cart);
		}
	}	
	
	public static void filterDVD(Store store, Cart cart) {
		System.out.println("Options: ");
		System.out.println("-----------------------------");
		System.out.println("1. Filter DVDs by ID");
		System.out.println("2. Filter DVDs by Title");
		System.out.println("0. Back");
		System.out.println("-----------------------------");
		System.out.println("Please choose a number: 0-1-2");
		Scanner choose = new Scanner(System.in);
		int choosen = choose.nextInt();
		if(choosen == 1) {
			System.out.println("Enter ID: ");
			Scanner inp = new Scanner(System.in);
			int id = inp.nextInt();
			cart.searchByID(id);
			filterDVD(store,cart);
		}
		else if(choosen == 2) {
			System.out.println("Enter Title: ");
			Scanner inp = new Scanner(System.in);
			String title = inp.next();
			cart.searchByTitle(title);
			filterDVD(store,cart);
		}
		else {
			cartMenu(store,cart);
		}
}
	public static void sortDVD(Store store, Cart cart) {
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
			sortDVD(store,cart);
		}
		else if(choosen == 2) {
			cart.sortByTitle();
			sortDVD(store,cart);
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
			store.addDVD(dvd);
			addDVD(store,cart);
		}
		if (choosen == 2) {
			System.out.println("Enter the title, category, cost (seperated by space): ");
			Scanner inp = new Scanner(System.in);
			String title = inp.next();
			String category = inp.next();
			float cost = inp.nextFloat();
			DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost);
			store.addDVD(dvd);
			addDVD(store,cart);

		}
		if (choosen == 3) {
			System.out.println("Enter the title, category, director, cost (seperated by space): ");
			Scanner inp = new Scanner(System.in);
			String title = inp.next();
			String category = inp.next();
			String director = inp.next();
			float cost = inp.nextFloat();
			DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, cost);
			store.addDVD(dvd);
			addDVD(store,cart);

		}
		if (choosen == 4) {
			System.out.println("Enter the title, category, director, length, cost (seperated by space): ");
			Scanner inp = new Scanner(System.in);
			String title = inp.next();
			String category = inp.next();
			String director = inp.next();
			int length = inp.nextInt();
			float cost = inp.nextFloat();
			DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
			store.addDVD(dvd);
			addDVD(store,cart);

		}
		if (choosen == 0) {
			updateStore(store, cart);
		}
		
	}

}
