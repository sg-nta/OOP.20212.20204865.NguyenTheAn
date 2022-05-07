
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
		


		
	}
}
