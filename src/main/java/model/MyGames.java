package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("serial")
public class MyGames implements Serializable {

	private List<Game> allGames;

	public MyGames() {
		super();
		allGames = new ArrayList<>();
	}

	public void addGame(Game newGame) {
		allGames.add(newGame);
	}

	public List<Game> getAllGames() {
		return allGames;
	}

	public void removeGame(Game game) {
		allGames.remove(game);
	}

	public List<Game> filterByTags(List<String> selectedTags) {
		return allGames.stream()
				.filter(game -> game.getTags().containsAll(selectedTags))
				.collect(Collectors.toList());
	}

	public List<Game> sortByName() {
		return allGames.stream()
				.sorted(Comparator.comparing(Game::getName))
				.collect(Collectors.toList());
	}

	public List<Game> sortByReleaseDate() {
		return allGames.stream()
				.sorted(Comparator.comparing(Game::getReleaseDate))
				.collect(Collectors.toList());
	}

	public List<Game> sortByNote() {
		return allGames.stream()
				.sorted(Comparator.comparing(Game::getNote).reversed())
				.collect(Collectors.toList());
	}

	public List<Game> findGameByName(String name) {
		return allGames.stream()
				.filter(game -> game.getName().equalsIgnoreCase(name))
				.collect(Collectors.toList());
	}

	public void affichageParTag(List<String> selectedTags) {
		List<Game> filteredGames = filterByTags(selectedTags);
		filteredGames.forEach(game -> {
			System.out.println("Name: " + game.getName());
			System.out.println("Image URL: " + game.getImageURL());
			System.out.println("Description: " + game.getDescription());
			System.out.println("Genre: " + game.getGenre());
			System.out.println("Release Date: " + game.getReleaseDate());
			System.out.println("Chart: " + game.getChart());
			System.out.println("Resume: " + game.getResume());
			System.out.println("Note: " + game.getNote());
			System.out.println("Tags: " + game.getTags());
			System.out.println("---------------------------------------------------");
		});
	}
}
