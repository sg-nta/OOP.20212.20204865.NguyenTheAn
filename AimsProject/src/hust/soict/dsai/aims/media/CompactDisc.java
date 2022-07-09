package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();

	public CompactDisc(String title, String category, float cost, int length, String director, String artist) {
		super();
		this.setTitle(title);
		this.setCategory(category);
		this.setCost(cost);
		this.setLength(length);
		this.setDirector(director);
		this.artist = artist;

		// TODO Auto-generated constructor stub
	}

	public String getArtist() {
		return artist;
	}
	public void addTrack(Track track) throws IllegalArgumentException{
		int check = 0;
		for (int i = 0; i < tracks.size(); i++ ) {
			if (tracks.get(i).getTitle().equals(track.getTitle())) {
				check += 1;
			}
		}
		if (check == 0) {
			tracks.add(track);
			System.out.println("This track has been added");
		}
		else {
			throw new IllegalArgumentException("This track is already in the cart");
		}
	}
	public void removeTrack(Track track) throws IllegalArgumentException{
		int index = -1;
		for (int i = 0; i < tracks.size(); i ++) {
			if (tracks.get(i).getTitle().equals(track.getTitle())) {
				index = i;
			}
		}
		if (index == -1) {
			throw new IllegalArgumentException("This track is not in the cart");
		}
		else {
			tracks.remove(index);
			System.out.println("This track has been removed");
		}
	}
	public int getLength() {
		int sum = 0;
		for (Track track: tracks) {
			sum += track.getLength();
		}
		return sum;
	}
	public void play() throws PlayerException {
		if(this.getLength() > 0) {
			System.out.println("Playing CD: " + this.getTitle());
	 		for (Track track: tracks) {
				try {
					track.play();
				}catch(PlayerException e) {
					throw e;
				}
			}
		}
		else {
			throw new PlayerException("ERROR: CD length is non-positive");
		}
	}
	public String playString() throws PlayerException{
		if(this.getLength() > 0) {
			String out = "Playing CD: " + this.getTitle() + "\n";
			for (Track track: tracks) {
				try {
					out += track.playString();
					out += "\n";
				}catch(PlayerException e) {
					throw e;
				}
			}
			return out;
		}
		else {
			throw new PlayerException("ERROR: CD length is non-positive");
		}
	}
	public String toString() {
		String result = "CD - " + super.toString() + " - Artist: " + this.getArtist();
		return result;
	}

	
	

}
