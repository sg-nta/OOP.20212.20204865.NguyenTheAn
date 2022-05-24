package hust.soict.dsai.aims.store;
import java.util.Scanner;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[1000];
	private int numItem = 0;
	public void addDVD(DigitalVideoDisc disc) {
		int check = 0;
		for (int i = 0; i < numItem; i++ ) {
			if (itemsInStore[i] == disc) {
				System.out.println("This disc is already in the store");
				check += 1;
			}
		}
		if (check == 0) {
			itemsInStore[numItem] = disc;
			System.out.println("Disc has been added to the store");
			numItem += 1;
		}
	}
	public void removeDVD(String title) {
		DigitalVideoDisc[] copy = new DigitalVideoDisc[numItem];
		int check = 0, count = 0;
		for (int i = 0; i < numItem; i ++) {
			if (itemsInStore[i].getTitle().equals(title)) {
				check += 1;
			}
			else {
				copy[count] = itemsInStore[i];
				count += 1;
			}
		}
		if (check == 0) {
			System.out.println("That disc is not in the store");
		}
		else {
			numItem -= check;
			System.out.println("All the discs named " + title + " have been removed");
		}
		itemsInStore = copy;
		
		
	}
	public void viewDetails(String title) {
		DigitalVideoDisc dvd = this.getDiscByTitle(title);
		if (dvd == null){
			System.out.println("No dvd matches the title");
		}
		else {
			System.out.println("DVD: " + dvd.toString());
		}
	}
	public void print() {
		for (int i = 0; i < numItem; i++) {
			System.out.println((i+1) + ". " + itemsInStore[i].toString());
		}
	}
	public DigitalVideoDisc getDiscByTitle(String title) {
		DigitalVideoDisc out = null ;
		for (int i = 0; i < numItem; i ++) {
			if (itemsInStore[i] != null) {
				if (itemsInStore[i].getTitle().equals(title)) {
					out = itemsInStore[i];
					break;
				}
			}
		}
		return out;
	}
}
