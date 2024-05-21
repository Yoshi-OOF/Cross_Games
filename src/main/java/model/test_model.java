package model;

import java.util.Arrays;
import java.util.List;

public class test_model {

    public static void main(String[] args) {
        MyGames SortedGames = new MyGames();
        Game game1 = new Game("Warframe", "url1", "desc1", "genre1", "2020-01-01", "chart1", "resume1", 8.5f, Arrays.asList("tag1", "tag2"));
        Game game2 = new Game("Call of Duty", "url2", "desc2", "genre2", "2019-01-01", "chart2", "resume2", 9.0f, Arrays.asList("tag2", "tag3"));
        Game game3 = new Game("Assassin's Creed", "url3", "desc3", "genre3", "2021-01-01", "chart3", "resume3", 7.5f, Arrays.asList("tag1", "tag3"));
        Game game4 = new Game("Minecraft", "url4", "desc4", "genre4", "2010-11-18", "chart4", "resume4", 9.3f, Arrays.asList("tag4", "tag5"));
        Game game5 = new Game("Fortnite", "url5", "desc5", "genre5", "2017-07-25", "chart5", "resume5", 8.0f, Arrays.asList("tag5", "tag6"));
        Game game6 = new Game("Overwatch", "url6", "desc6", "genre6", "2016-05-24", "chart6", "resume6", 8.7f, Arrays.asList("tag6", "tag7"));
        Game game7 = new Game("League of Legends", "url7", "desc7", "genre7", "2009-10-27", "chart7", "resume7", 9.5f, Arrays.asList("tag7", "tag8"));
        Game game8 = new Game("Apex Legends", "url8", "desc8", "genre8", "2019-02-04", "chart8", "resume8", 8.8f, Arrays.asList("tag8", "tag9"));
        Game game9 = new Game("FIFA 22", "url9", "desc9", "genre9", "2021-10-01", "chart9", "resume9", 8.2f, Arrays.asList("tag9", "tag10"));
        Game game10 = new Game("The Witcher 3: Wild Hunt", "url10", "desc10", "genre10", "2015-05-19", "chart10", "resume10", 9.8f, Arrays.asList("tag10", "tag11"));

        MyGames myGames = new MyGames();
        myGames.addGame(game1);
        myGames.addGame(game2);
        myGames.addGame(game3);
        myGames.addGame(game4);
        myGames.addGame(game5);
        myGames.addGame(game6);
        myGames.addGame(game7);
        myGames.addGame(game8);
        myGames.addGame(game9);
        myGames.addGame(game10);

        List<Game> sortedByNote = myGames.sortByNote();
        myGames.afficherJeux();
    }
}
