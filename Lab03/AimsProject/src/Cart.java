
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
			for (int i = 0; i < 20; i ++) {
				if (itemOrdered[i] == null) {
					itemOrdered[i] = disc;
					qtyOrdered += 1;
					System.out.println("The disc has been added");
					
					break;
				}
			}
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		if (qtyOrdered == 20) {
			System.out.println("Cart is already full ");
		}
		else if (qtyOrdered + dvdList.length > 20) {
			System.out.println("Cart will be full if add all of these dvds");
		}
		else {
			for (int i = 0; i < 20; i++) {
				if (itemOrdered[i] == null) {
					for (int j = 0; j < dvdList.length; j++) {
						if (dvdList[j] != null) {
							itemOrdered[i] = dvdList[j];
							System.out.println("Add disc " + dvdList[j].getTitle());
							dvdList[j] = null;
							qtyOrdered += 1;
							break;
						}
					}
				}
			}
			System.out.println("The discs have been added " + qtyOrdered );
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0; i < 20; i ++) {
			if (itemOrdered[i] == disc) {
				itemOrdered[i] = null;
				qtyOrdered -= 1;
				System.out.println("The disc " + disc + " has been removed");
				break;
			}
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
