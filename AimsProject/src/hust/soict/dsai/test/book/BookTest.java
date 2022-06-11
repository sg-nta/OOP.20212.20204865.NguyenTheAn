package hust.soict.dsai.test.book;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Book;

public class BookTest {
	public static void main (String args[]) {
		List<String> authors = new ArrayList<String>();
		authors.add("Adam");
		authors.add("Eve");
		Book book = new Book(authors);
		book.setContent("This is a this a simple test sentence this there id an sentences");
		book.processContent();
		System.out.println(book.toString());
	}
}
