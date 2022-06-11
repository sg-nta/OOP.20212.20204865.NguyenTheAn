package hust.soict.dsai.aims.store;
import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class Store {
	private ArrayList<Media> itemsInStore = new	ArrayList<Media>();
	public void addMedia(Media media) {
		int check = 0;
		for (int i = 0; i < itemsInStore.size(); i++ ) {
			if (itemsInStore.get(i).getTitle().equals(media.getTitle())) {
				System.out.println("This media is already in the store");
				check += 1;
			}
		}
		if (check == 0) {
			itemsInStore.add(media);
			System.out.println("This media has been added to store");
		}
		this.setID();
	}
	public void removeMedia(Media media) {
		int index = -1;
		for (int i = 0; i < itemsInStore.size(); i ++) {
			if (itemsInStore.get(i).getTitle().equals(media.getTitle())) {
				index = i;
			}
		}
		if (index == -1) {
			System.out.println("This media is not in the store");
		}
		else {
			itemsInStore.remove(index);
			System.out.println("This media has been removed");
		}
		this.setID();
	}	
	public void viewDetails(String title) {
		Media dvd = this.getMediaByTitle(title);
		if (dvd == null){
			System.out.println("No media matches the title");
		}
		else {
			System.out.println("DVD: " + dvd.toString());
		}
	}
	public void print() {
		for (int i = 0; i < itemsInStore.size(); i++) {
			System.out.println((i+1) + ". " + itemsInStore.get(i).toString());
		}
	}
	public Media getMediaByTitle(String title) {
		Media out = null ;
		for (int i = 0; i < itemsInStore.size(); i ++) {
			if (itemsInStore.get(i).getTitle().equals(title)) {
				out = itemsInStore.get(i);
				break;
			}
		}
		return out;
	}
	public void playMedia(String title) {
		Media media = this.getMediaByTitle(title);
		if (media instanceof Playable) {
			((Playable) media).play();
		}
	}
	public void setID() {
		for (int i = 0; i < itemsInStore.size(); i++ ) {
			itemsInStore.get(i).setID(i);
		}
	}
}
