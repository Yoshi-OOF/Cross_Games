package model;

import java.util.Arrays;
import java.util.List;

public class test_model {

    public static void main(String[] args) {
        // Création d'exemples de jeux
        Game game1 = new Game("Game1", "url1", "desc1", "genre1", "2020-01-01", "chart1", "resume1", 8.5f, Arrays.asList("tag1", "tag2"));
        Game game2 = new Game("Game2", "url2", "desc2", "genre2", "2019-01-01", "chart2", "resume2", 9.0f, Arrays.asList("tag2", "tag3"));
        Game game3 = new Game("Game3", "url3", "desc3", "genre3", "2021-01-01", "chart3", "resume3", 7.5f, Arrays.asList("tag1", "tag3"));

        // Ajout des jeux à MyGames
        MyGames myGames = new MyGames();
        myGames.addGame(game1);
        myGames.addGame(game2);
        myGames.addGame(game3);

        // Affichage des jeux filtrés par tags
        List<String> selectedTags = Arrays.asList("tag1");
        myGames.affichageParTag(selectedTags);

        myGames.sortByNote();
        myGames.affichageParTag(selectedTags);

    
    }
}
