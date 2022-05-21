package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
	private String title, category, director;
	private int length, ID;
	private float cost;
	private static int nbDigitalVideoDiscs = 0;
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		DigitalVideoDisc.nbDigitalVideoDiscs += 1;
		this.ID = DigitalVideoDisc.nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		DigitalVideoDisc.nbDigitalVideoDiscs += 1;
		this.ID = DigitalVideoDisc.nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		DigitalVideoDisc.nbDigitalVideoDiscs += 1;
		this.ID = DigitalVideoDisc.nbDigitalVideoDiscs;
	}
	public void DigitalVideoDisc1(String category) {
		this.category = category;
		DigitalVideoDisc.nbDigitalVideoDiscs += 1;
		this.ID = DigitalVideoDisc.nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		DigitalVideoDisc.nbDigitalVideoDiscs += 1;
		this.ID = DigitalVideoDisc.nbDigitalVideoDiscs;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public int getID() {
		return ID;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String toString() {
		String s = "DVD - " + this.title + " - " + this.category + " - " + this.director + " - " + this.length + " : " + this.cost + " $";
		return s;
	}
	public boolean isMatch(String title) {
		String generalTitle = this.title.toLowerCase();
		boolean result = false;
		String[] titleList = title.split(" ");
		for (String titleListPart : titleList) {
				if (generalTitle.contains(titleListPart.toLowerCase())) {
					result = true;
				}
			}
		return result;
	}
}
