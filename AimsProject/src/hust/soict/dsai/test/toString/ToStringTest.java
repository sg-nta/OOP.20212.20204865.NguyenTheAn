package hust.soict.dsai.test.toString;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class ToStringTest {

	public static void main (String args[]) {
		List<Media> mediae = new ArrayList<Media>();
		// create some media here
		// for example: cd, dvd, book
		DigitalVideoDisc dvd = new DigitalVideoDisc("Jungle");
		CompactDisc cd = new CompactDisc("Chay ngay di", "Pop",3.5f, 3, "Ko biet", "Moutain");
		List<String> authors = new ArrayList<String>();
		authors.add("Adam");
		authors.add("Eve");
		Book book = new Book(authors);
		book.setContent("ab dc def asd cdvji dofkd cok apdsaps  spc adamsdkc mdmvdv ; df kdmsc damkc ");
		book.processContent();
		mediae.add(cd);
		mediae.add(dvd);
		mediae.add(book);
		for (Media m : mediae) {
			System.out.println(m.toString());
		}
	}

}
