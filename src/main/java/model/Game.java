package model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

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
	private List<String> tags;

	public Game(String name, String imageURL, String description, String genre, String releaseDate, String chart, String resume, float note, List<String> tags) {
		super();
		this.name = name;
		this.imageURL = imageURL;
		this.description = description;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.chart = chart;
		this.resume = resume;
		this.note = note;
		this.tags = tags;
	}

	public Game() {
		super();
		this.name = "";
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
		return "Name: " + this.name + "\n" +
				"Image URL: " + this.imageURL + "\n" +
				"Description: " + this.description + "\n" +
				"Genre: " + this.genre + "\n" +
				"Release Date: " + this.releaseDate + "\n" +
				"Chart: " + this.chart + "\n" +
				"Resume: " + this.resume + "\n" +
				"Note: " + this.note + "\n" +
				"Tags: " + this.tags + "\n";
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

	public void addTag(String tag) {
		tags.add(tag);
	}

	public void removeTag(String tag) {
		tags.remove(tag);
	}

	public List<String> getTags() {
		return tags;
	}

}
