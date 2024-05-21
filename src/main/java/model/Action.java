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

    public static void affichageParTag(MyGames myGames, List<String> selectedTags) {
        List<Game> filteredGames = filterByTags(myGames, selectedTags);
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
