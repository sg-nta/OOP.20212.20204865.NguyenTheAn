package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable, Comparable<Track>{
	private String title;
	private int length;
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	public void play() throws PlayerException{
		if (this.getLength() > 0) {
			System.out.println("Playing track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
		}else {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
	}
	public String playString() throws PlayerException{
		if (this.getLength() > 0) {
			String out = "Playing track: " + this.getTitle() + "\n" + "Track length: " + this.getLength();
			return out;
		}else {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
	}
	public boolean equals(Object o) {
		if (o instanceof Track) {
			Track track = (Track) o;
			return (this.getTitle().equals(track.getTitle()) && this.getLength() == track.getLength());
		}
		return false;
	}
	public String toString() {
		String result = "Title: " + this.getTitle() + " - Length: " + this.getLength();
		return result;
	}
	@Override
	public int compareTo(Track o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
