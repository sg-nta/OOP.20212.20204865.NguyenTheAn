package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemOrdered[] =
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == 20) {
			System.out.println("Cart is full");
		}
		else {
			int count = 0;
			int notfull = 0;
			for (int i = 0; i < 20; i ++) {
				if (itemOrdered[i] == null) {
					for (int j = 0; j < 20; j ++) {
						if (itemOrdered[j] == disc){
							System.out.println("This disc is already in your cart");
							count += 1;
							break;
						}
 					}
					if (count == 0){
						itemOrdered[i] = disc;
						qtyOrdered += 1;
						notfull += 1;
						System.out.println("The disc " + disc.getTitle() + " has been added");
						count += 1;
					}
					if (count == 1) {
						break;
					}
				}
			}
			if (notfull == 0 && count == 0){
				System.out.println("Your cart is already full!");
			}
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		if (qtyOrdered == 20) {
			System.out.println("Cart is full");
		}
		else {
			int nonadded = dvdList.length;
			for (int k = 0; k < dvdList.length; k++){
				int count = 0;
				int notfull = 0;
				for (int i = 0; i < 20; i ++) {
					if (itemOrdered[i] == null) {
						for (int j = 0; j < 20; j ++) {
							if (itemOrdered[j] == dvdList[k]){
								System.out.println("This disc is already in your cart");
								count += 1;
								break;
							}
	 					}
						if (count == 0){
							itemOrdered[i] = dvdList[k];
							qtyOrdered += 1;
							dvdList[k] = null;
							notfull +=1;
							count += 1;
							nonadded -= 1;
						}
						if (count == 1) {
							break;
						}
					}
					
				} 
				if (notfull == 0 && count == 0){
					System.out.println("Your cart is already full!");
					break;
				}
			}
			if (nonadded > 0) {
				System.out.println("Number of discs added: " + (dvdList.length - nonadded));
				System.out.print("There are some discs that are not added as cart is full: ");
				for (int k = 0; k < dvdList.length; k++) {
					if (dvdList[k] != null) {
						System.out.print("Disc " + dvdList[k].getTitle() + ", ");
					}
				}
				System.out.println();
				
				
			}
			if (nonadded == 0) {
				System.out.println("All the discs have been added");
			}
		}
		}
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2 ) {
		DigitalVideoDisc dvdList[] = new DigitalVideoDisc[2]; 
		dvdList[0] = dvd1;
		dvdList[1] = dvd2;
		addDigitalVideoDisc(dvdList);
		}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int check = 0;
		for (int i = 0; i < 20; i ++) {
			if (itemOrdered[i] != null) {
				if (itemOrdered[i].getTitle() == disc.getTitle()) {
					itemOrdered[i] = null;
					qtyOrdered -= 1;
					check += 1;
					System.out.println("The disc " + disc.getTitle() + " has been removed");
					break;
				}
			}
		}
		if (check == 0) {
			System.out.println("That disc is not in the current cart");
		}
	}
	public float totalCost() {
		float cost = 0;
		for (int i = 0; i < 20; i ++) {
			if (itemOrdered[i] != null) {
				cost += itemOrdered[i].getCost();
			}
		}
		return cost;
	}
	public void sortByCost() {
		ArrayList<DigitalVideoDisc> list = new ArrayList<>();
		for (DigitalVideoDisc disc:itemOrdered) {
			if (disc != null) {
				list.add(disc);
			}
		}
		List<DigitalVideoDisc> result = (ArrayList<DigitalVideoDisc>) list.stream().sorted(Comparator.comparing(DigitalVideoDisc::getCost)).collect(Collectors.toList());
		System.out.println("Sort by cost: ");
		for (int i = 0; i< list.size(); i++) {
			System.out.print(result.get(i).getTitle() + " , ");
		}
		System.out.println("");
	}
	public void sortByTitle() {
		ArrayList<DigitalVideoDisc> list = new ArrayList<>();
		for (DigitalVideoDisc disc:itemOrdered) {
			if (disc != null) {
				list.add(disc);
			}
		}
		List<DigitalVideoDisc> result = (ArrayList<DigitalVideoDisc>) list.stream().sorted(Comparator.comparing(DigitalVideoDisc::getTitle)).collect(Collectors.toList());
		System.out.println("Sort by title: ");
		for (int i = 0; i< list.size(); i++) {
			System.out.print(result.get(i).getTitle() + " , ");
		}
		System.out.println("");
	}
	public void searchByID(int ID) {
		int count = 0;
		for (DigitalVideoDisc disc:itemOrdered) {
			if (disc != null) {
				if (disc.getID() == ID) {
					System.out.println("Found disc: " + disc + " matches the ID " + ID);
					count += 1;
				}
			}
		}	
		if (count == 0) {
			System.out.println("No item matches the ID " + ID);
		}
		
	}
	public void print() {
		ArrayList<DigitalVideoDisc> list = new ArrayList<>();
		for (DigitalVideoDisc disc:itemOrdered) {
			if (disc != null) {
				list.add(disc);
			}
		}
		List<DigitalVideoDisc> result = (ArrayList<DigitalVideoDisc>) list.stream().sorted(Comparator.comparing(DigitalVideoDisc::getTitle).thenComparing(DigitalVideoDisc::getCost).reversed().thenComparing(DigitalVideoDisc::getLength).reversed()).collect(Collectors.toList());
		System.out.println("***********************CART*********************** ");
		System.out.println("Ordered Items: ");
		for (int i = 0; i< list.size(); i++) {
			DigitalVideoDisc item = result.get(i);
			System.out.print((i+1) + ". " + item.toString());
			System.out.println("");
		}
		System.out.println("Total cost: " + this.totalCost());
		System.out.println("***************************************************");
	}
	public void searchByTitle(String title) {
		DigitalVideoDisc[] result = new DigitalVideoDisc[20];
		int count = 0;
		for (DigitalVideoDisc disc: itemOrdered) {
			if (disc!= null) {
				if (disc.isMatch(title) == true) {
					result[count] = disc;
					count += 1;
				}
			}
		}
		if (count > 1) {
			System.out.print("List of discs match the title: ");
			for (DigitalVideoDisc disc: result) {
				if (disc != null) {
					System.out.print(disc.getTitle() + " , ");
				}
			}
			System.out.println("");
		}
		else if (count == 1) {
			System.out.print("Found one disc matches the title: " + result[0].getTitle());
			System.out.println("");
		}
		else {
			System.out.println("No disc matches the tilte");
		}
	}
	public void emptyCart() {
		for (DigitalVideoDisc dvd: itemOrdered) {
			dvd = null;
		}
	}
}
