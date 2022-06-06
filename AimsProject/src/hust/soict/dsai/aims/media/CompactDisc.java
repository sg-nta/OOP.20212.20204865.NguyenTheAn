package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();

	public CompactDisc(String artist) {
		super();
		this.artist = artist;

		// TODO Auto-generated constructor stub
	}

	public String getArtist() {
		return artist;
	}
	public void addTrack(Track track) {
		int check = 0;
		for (int i = 0; i < tracks.size(); i++ ) {
			if (tracks.get(i).getTitle().equals(track.getTitle())) {
				System.out.println("This track is already in the disc");
				check += 1;
			}
		}
		if (check == 0) {
			tracks.add(track);
			System.out.println("This track has been added");
		}
	}
	public void removeTrack(Track track) {
		int index = -1;
		for (int i = 0; i < tracks.size(); i ++) {
			if (tracks.get(i).getTitle().equals(track.getTitle())) {
				index = i;
			}
		}
		if (index == -1) {
			System.out.println("This track is not in the disc");
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
	public void play() {
		for (Track track: tracks) {
			track.play();
		}
	}
	

}