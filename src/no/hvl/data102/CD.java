package no.hvl.data102;

public class CD {
	
	private int cdNumber;
	private String artist;
	private String cdTitle;
	private int releaseYear;
	public enum Genre {POP, ROCK, OPERA, CLASSIC}
	Genre genre;
	private String cdCompany;
		
	public CD() {
		cdNumber = 0;
		artist = "";
		cdTitle = "";
		releaseYear = 0;
		genre = null;
		cdCompany = "";	
	}

	public CD(int cdNumber, String artist, String cdTitle, int releaseYear, Genre genre, String cdCompany) {

		this.cdNumber = cdNumber;
		this.artist = artist;
		this.cdTitle = cdTitle;
		this.releaseYear = releaseYear;
		this.genre = genre;
		this.cdCompany = cdCompany;
		
	}

	public int getCdNumber() {
		return cdNumber;
	}

	public void setCdNumber(int cdNumber) {
		this.cdNumber = cdNumber;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getCdTitle() {
		return cdTitle;
	}

	public void setCdTitle(String cdTitle) {
		this.cdTitle = cdTitle;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String getCdCompany() {
		return cdCompany;
	}

	public void setCdCompany(String cdCompany) {
		this.cdCompany = cdCompany;
	}

	@Override
	public String toString() {
		return "CD [cdNumber=" + cdNumber + ", artist=" + artist + ", cdTitle=" + cdTitle + ", releaseYear="
				+ releaseYear + ", genre=" + genre + ", cdCompany=" + cdCompany + "]";
	}
	

}
