
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
			if (itemOrdered[i] == disc) {
				itemOrdered[i] = null;
				qtyOrdered -= 1;
				check += 1;
				System.out.println("The disc " + disc.getTitle() + " has been removed");
				break;
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
}
