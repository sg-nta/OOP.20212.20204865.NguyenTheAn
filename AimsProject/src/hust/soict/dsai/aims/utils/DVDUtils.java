package hust.soict.dsai.aims.utils;
import java.util.*;
import java.util.stream.Collectors;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
public class DVDUtils {
	public static String compareByCost(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		String s = null;
		if (dvd1.getCost() > dvd2.getCost()) {
			s = "Disc " + dvd1.getTitle() + " is expensive than " + dvd2.getTitle();
		}
		else if(dvd1.getCost() < dvd2.getCost()) {
			s = "Disc " + dvd2.getTitle() + " is expensive than " + dvd1.getTitle();
		}
		else if(dvd1.getCost() == dvd2.getCost()) {
			s = "Two discs have the same cost";
		}
		return s;
	}
	public static String compareByTitle(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		String s = null;
		if (dvd1.getTitle().equals(dvd2.getTitle())) {
			s = "Two discs have the same title";
		}
		else {
			s = "Two discs have different titles";
		}
		return s;
	}
	public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc[] dvdList) {
		ArrayList<DigitalVideoDisc> list = new ArrayList<>();
		for (DigitalVideoDisc disc:dvdList) {
			list.add(disc);
		}
		List<DigitalVideoDisc> result = (ArrayList<DigitalVideoDisc>) list.stream().sorted(Comparator.comparing(DigitalVideoDisc::getCost)).collect(Collectors.toList());
		DigitalVideoDisc[] out = new DigitalVideoDisc[list.size()];
		for (int i = 0; i< list.size(); i++) {
			out[i] = result.get(i);
		}
		return out;
	}
	public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc[] dvdList) {
		ArrayList<DigitalVideoDisc> list = new ArrayList<>();
		for (DigitalVideoDisc disc:dvdList) {
			list.add(disc);
		}
		List<DigitalVideoDisc> result = (ArrayList<DigitalVideoDisc>) list.stream().sorted(Comparator.comparing(DigitalVideoDisc::getTitle)).collect(Collectors.toList());
		DigitalVideoDisc[] out = new DigitalVideoDisc[list.size()];
		for (int i = 0; i< list.size(); i++) {
			out[i] = result.get(i);
		}
		return out;
	}
	
}
