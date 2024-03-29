package hust.soict.dsai.aims.media;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public abstract class Media implements Comparable<Media> {
	private String title;
	private String category;
	private float cost;
	private LocalDate dateAdded;
	protected int ID;
	protected ArrayList<Media> mediaList = new	ArrayList<Media>();
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

	public Media() {
		// TODO Auto-generated constructor stub
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public LocalDate getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}
	public boolean isMatch(String title) {
		String generalTitle = this.getTitle().toLowerCase();
		boolean result = false;
		String[] titleList = title.split(" ");
		for (String titleListPart : titleList) {
				if (generalTitle.contains(titleListPart.toLowerCase())) {
					result = true;
				}
			}
		return result;
	}
	public int getID() {
		return ID;
	}
	public void setID(int id) {
		this.ID = id;
	}
	public boolean equals(Object o) throws NullPointerException, ClassCastException{
		if (o != null) {
			if (o instanceof Media) {
				Media media = (Media) o;
				return (this.getTitle().equals(media.getTitle()) && (this.getCost() == media.getCost()));
			}
			else {
				throw new ClassCastException();
			}
		}
		else {
			throw new NullPointerException();
		}
	}
	public String toString() {
		String result = "ID: " + this.getID() + " - Title: " + this.getTitle() + " - Category: " + this.getCategory() + " - Cost: " + this.getCost();
		return result;
	}

	@Override
	public int compareTo(Media media) {
		if (media != null) {
			return Comparator.comparing(Media::getTitle).thenComparing(Media::getCategory).compare(this, media);
		}
		else {
			throw new NullPointerException();
		}
	}
	

}

