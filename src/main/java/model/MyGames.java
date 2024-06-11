package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
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
		List<Game> filteredGames = new ArrayList<>();
		for (Game game : allGames) {
			if (new HashSet<>(game.getTags()).containsAll(selectedTags)) {
				filteredGames.add(game);
			}
		}
		return filteredGames;
	}

	public List<Game> sortByName() {
		List<Game> sortedGames = new ArrayList<>(allGames);
		sortedGames.sort(Comparator.comparing(Game::getName));
		return sortedGames;
	}

	public List<Game> sortByReleaseDate() {
		List<Game> sortedGames = new ArrayList<>(allGames);
		sortedGames.sort(Comparator.comparing(Game::getReleaseDate));
		return sortedGames;
	}

	public List<Game> sortByNote() {
		List<Game> sortedGames = new ArrayList<>(allGames);
		sortedGames.sort(Comparator.comparing(Game::getNote).reversed());
		return sortedGames;
	}

	public List<Game> findGameByName(String name) {
		List<Game> matchingGames = new ArrayList<>();
		for (Game game : allGames) {
			if (game.getName().equalsIgnoreCase(name)) {
				matchingGames.add(game);
			}
		}
		return matchingGames;
	}

	public void showByTag(List<String> selectedTags) {
		List<Game> filteredGames = filterByTags(selectedTags);
		filteredGames.forEach(game -> {
			System.out.println(game);
		});
	}

	public void afficherJeux() {
		afficherJeux(allGames);
	}

	public void afficherJeux(List<Game> games) {
		games.forEach(game -> {
			System.out.println(game);
		});
	}
}
