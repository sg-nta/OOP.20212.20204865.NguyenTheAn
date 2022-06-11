package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	public Book(List<String> authors) {
		// TODO Auto-generated constructor stub
		this.authors = authors;
	}
	private List<String> getAuthors() {
		return authors;
	}
	private void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	public void addAuthor(String authorName) {
		int check = 0;
		for (int i = 0; i < authors.size(); i++ ) {
			if (authors.get(i).equals(authorName)) {
				System.out.println("This author is already in the list");
				check += 1;
			}
		}
		if (check == 0) {
			authors.add(authorName);
			System.out.println("This author's name has been added");
		}
	}
	public void removeAuthor(String authorName) {
		int index = -1;
		for (int i = 0; i < authors.size(); i ++) {
			if (authors.get(i).equals(authorName)) {
				index = i;
			}
		}
		if (index == -1) {
			System.out.println("This author's name is not in the list");
		}
		else {
			authors.remove(index);
			System.out.println("This author's name has been removed");
		}
	}
	public String toString() {
		String result = "Book - " + super.toString() + " - Author: " + this.getAuthors();
		return result;
	}
	

}
