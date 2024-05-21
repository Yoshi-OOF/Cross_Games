package model;

import java.io.Serializable;
import java.util.Comparator;

@SuppressWarnings("serial")
public class Game implements Comparator<Game>, Serializable {

	private String name;
	private String imageURL;
	private String description;
	private String genre;
	private String releaseDate;
	private String chart;
	private String resume;
	private float note;


	public Game(String name, String imageURL, String description, String genre, String releaseDate, String chart, String resume, float note) {
		super();
		this.name = name;
		this.imageURL = imageURL;
		this.description = description;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.chart = chart;
		this.resume = resume;
		this.note = note;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	@Override
    public String toString() {
        return name;
    }

	@Override
	public int compare(Game o1, Game o2) {
		return o1.name.compareTo(o2.name);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getChart() {
		return chart;
	}

	public void setChart(String chart) {
		this.chart = chart;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public float getNote() {
		return note;
	}

	public void setNote(float note) {
		this.note = note;
	}


}
