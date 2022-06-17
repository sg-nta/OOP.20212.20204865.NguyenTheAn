package hust.soict.dsai.aims.media;

public class Disc extends Media {
	private int length;
	private String director;
	public Disc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Disc(int length, String director) {
		this.length = length;
		this.director = director;
	}
	public Disc(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}
	public String toString() {
		String result = super.toString() + " - Length: " + this.getLength() + " - Director: " + this.getDirector();
		return result;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public void setDirector(String director) {
		this.director = director;
	}

}
