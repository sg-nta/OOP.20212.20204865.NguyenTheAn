package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import java.util.Iterator;
import java.util.Collection;
import java.util.Collections;

import java.util.ArrayList;
public class TestMediaCompareTo {
	public static void main (String[] args  ) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation","Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction","George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		Collection collection = new ArrayList();
		collection.add(dvd1);
		collection.add(dvd2);
		collection.add(dvd3);
		
		Iterator iterator = collection.iterator();
		System.out.println("-------------------------");
		System.out.println("The DVDs currently in the order are: ");
		while (iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
		}
		Collections.sort((java.util.List) collection);
		iterator = collection.iterator();
		System.out.println("--------------------------");
		System.out.println("The DVDs in sorted order are: ");
		while (iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());

		}
		System.out.println("--------------------------");

	
	}
}
