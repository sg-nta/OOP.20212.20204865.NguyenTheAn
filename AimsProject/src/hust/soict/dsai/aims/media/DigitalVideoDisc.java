package hust.soict.dsai.aims.media;

import java.time.LocalDate;

public class DigitalVideoDisc extends Disc implements Playable{
	private static int nbDigitalVideoDiscs = 0;
	private LocalDate dateAdded;
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(director);
		this.setTitle(title);
		this.setCategory(category);
		this.setCost(cost);
		DigitalVideoDisc.nbDigitalVideoDiscs += 1;
		this.ID = DigitalVideoDisc.nbDigitalVideoDiscs;
		this.setDateAdded(LocalDate.now());
	}
	public DigitalVideoDisc(String title) {
		super();
		this.setTitle(title);
		DigitalVideoDisc.nbDigitalVideoDiscs += 1;
		this.ID = DigitalVideoDisc.nbDigitalVideoDiscs;
		this.setDateAdded(LocalDate.now());

	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(length, director);
		this.setTitle(title);
		this.setCategory(category);
		this.setCost(cost);
		DigitalVideoDisc.nbDigitalVideoDiscs += 1;
		this.ID = DigitalVideoDisc.nbDigitalVideoDiscs;
		this.setDateAdded(LocalDate.now());

	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.setTitle(title);
		this.setCategory(category);
		this.setCost(cost);
		DigitalVideoDisc.nbDigitalVideoDiscs += 1;
		this.ID = DigitalVideoDisc.nbDigitalVideoDiscs;
		this.setDateAdded(LocalDate.now());

	}
	public String toString() {
		String s = "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + " : " + this.getCost() + " $";
		return s;
	}
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());	}
}
