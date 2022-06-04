package hust.soict.dsai.aims.media;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Media {
	private String title;
	private String category;
	private float cost;
	private LocalDate dateAdded;
	protected int ID;
	protected ArrayList<Media> mediaList = new	ArrayList<Media>();
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

}
