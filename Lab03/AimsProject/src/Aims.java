
public class Aims {
	public static void main(String[] args) {
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
		
		//Test method removeDigitalVideoDisc
		anOrder.removeDigitalVideoDisc(dvd2);
		System.out.println("Total Cost is: " + anOrder.totalCost());
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("XYZ",
				"Animation", 200f);
		anOrder.addDigitalVideoDisc(dvd4);
		System.out.println("Total Cost is: " + anOrder.totalCost());
		
		//Test method addDigitalVideoDisc for list of discs
		DigitalVideoDisc[] discArr = new DigitalVideoDisc[4];
		discArr[0] = dvd1;
		discArr[1] = dvd2;
		discArr[2] = dvd3;
		discArr[3] = dvd4;
		anOrder.addDigitalVideoDisc(discArr);
		System.out.println("Total Cost is: " + anOrder.totalCost());
	
	}
}
