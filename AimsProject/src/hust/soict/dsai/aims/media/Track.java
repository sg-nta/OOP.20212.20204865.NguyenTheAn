package hust.soict.dsai.aims.media;

public class Track implements Playable{
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
	public void play() {
		System.out.println("Playing track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
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
}
