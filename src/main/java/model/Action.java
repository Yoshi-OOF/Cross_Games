package model;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Action {

    public static List<Game> filterByTags(MyGames myGames, List<String> selectedTags) {
        return myGames.getAllGames().stream()
                .filter(game -> game.getTags().containsAll(selectedTags))
                .collect(Collectors.toList());
    }

    public static List<Game> sortByName(MyGames myGames) {
        return myGames.getAllGames().stream()
                .sorted(Comparator.comparing(Game::getName))
                .collect(Collectors.toList());
    }

    public static List<Game> sortByReleaseDate(MyGames myGames) {
        return myGames.getAllGames().stream()
                .sorted(Comparator.comparing(Game::getReleaseDate))
                .collect(Collectors.toList());
    }

    public static List<Game> sortByNote(MyGames myGames) {
        return myGames.getAllGames().stream()
                .sorted(Comparator.comparing(Game::getNote).reversed())
                .collect(Collectors.toList());
    }

    public static List<Game> findGameByName(MyGames myGames, String name) {
        return myGames.getAllGames().stream()
                .filter(game -> game.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }
}
