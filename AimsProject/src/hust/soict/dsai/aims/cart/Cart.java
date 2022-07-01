package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.lang.Math;
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	private double totalCost = this.totalCost();
	public float totalCost() {
		float cost = 0;
		for (Media media: itemsOrdered) {
			cost += media.getCost();
		}
		return cost;
	}
	public void addMedia(Media media) {
		if (media == null) {
			System.out.println("This media is not in the store");
		}
		else {
			if (itemsOrdered.size() == 20) {
				System.out.println("Your cart is already full");
			}
			else {
				int check = 0;
				for (int i = 0; i < itemsOrdered.size(); i++ ) {
					if (itemsOrdered.get(i).getTitle().equals(media.getTitle())) {
						System.out.println("This media is already in the cart");
						check += 1;
					}
				}
				if (check == 0) {
					itemsOrdered.add(media);
					System.out.println("This media has been added");
				}
	
			}
		}
	}
	public void removeMedia(Media media) {
		int index = -1;
		for (int i = 0; i < itemsOrdered.size(); i ++) {
			if (itemsOrdered.get(i).getTitle().equals(media.getTitle())) {
				index = i;
			}
		}
		if (index == -1) {
			System.out.println("This media is not in the cart");
		}
		else {
			itemsOrdered.remove(index);
			System.out.println("This media has been removed");
		}
	}
	public void sortByCost() {
		Collections.sort(itemsOrdered,Media.COMPARE_BY_COST_TITLE);
		System.out.println("Sorted by Cost (then Title): ");
		for (int i = 0; i< itemsOrdered.size(); i++) {
			System.out.println(i + ". Title: "  + itemsOrdered.get(i).getTitle() + " , Cost: " + itemsOrdered.get(i).getCost());
		}
	}
	public void sortByTitle() {
		Collections.sort(itemsOrdered,Media.COMPARE_BY_TITLE_COST);
		System.out.println("Sorted by Title (then Cost): ");
		for (int i = 0; i< itemsOrdered.size(); i++) {
			System.out.println(i + ". Title: "  + itemsOrdered.get(i).getTitle() + " , Cost: " + itemsOrdered.get(i).getCost());
		}
	}
	public void searchByID(int ID) {
		int count = 0;
		for (Media media:itemsOrdered) {
			if (media.getID() == ID) {
				System.out.println("Found media: " + media.getTitle() + " matches the ID " + ID);
				count += 1;
			}
			
		}	
		if (count == 0) {
			System.out.println("No item matches the ID " + ID);
		}
		
	}
	public void print() {
		List<Media> result = (ArrayList<Media>) itemsOrdered.stream().sorted(Comparator.comparing(Media::getTitle).thenComparing(Media::getCost).reversed()).collect(Collectors.toList());
		System.out.println("***********************CART*********************** ");
		System.out.println("Ordered Items: ");
		for (int i = 0; i< itemsOrdered.size(); i++) {
			Media item = result.get(i);
			System.out.print((i+1) + ". " + item.toString());
			System.out.println("");
		}
		System.out.println("Total cost: " + this.totalCost);
		System.out.println("***************************************************");
	}
	public void searchByTitle(String title) {
		ArrayList<Media> result = new	ArrayList<Media>();
		for (Media media: itemsOrdered) {
			if (media.isMatch(title) == true) {
				result.add(media);
			}
		}
		if (result.size() > 1) {
			System.out.print("List of medias match the title: ");
			for (Media media: result) {
				System.out.print(media.getTitle() + " , ");
			}
			System.out.println("");
		}
		else if (result.size() == 1) {
			System.out.print("Found one media matches the title: " + result.get(0).getTitle());
			System.out.println("");
		}
		else {
			System.out.println("No media matches the tilte");
		}
	}
	public void emptyCart() {
		while (itemsOrdered.size() > 0) {
			itemsOrdered.remove(0);
		}
	}
	public Media getALuckyItem() {
		Media lucky = null;
		if (itemsOrdered.size() >= 5) {
			int randNum = (int) Math.random()*5;
			lucky = itemsOrdered.get(randNum);
			this.totalCost -= lucky.getCost();
		}
		return lucky;
	}
	public double getTotalCost() {
		return this.totalCost;
	}
	public void playMedia(String title) {
		Media media = null ;
		for (int i = 0; i < itemsOrdered.size(); i ++) {
			if (itemsOrdered.get(i).getTitle().equals(title)) {
				media = itemsOrdered.get(i);
				break;
			}
		}
		if (media instanceof Playable) {
			((Playable) media).play();
		}
	}
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	
}
