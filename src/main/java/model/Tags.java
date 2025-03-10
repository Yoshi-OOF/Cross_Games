package model;

import java.util.ArrayList;
import java.util.List;

public class Tags {

        private String name;
        private List<Game> games;

        public Tags(String name) {
            super();
            this.name = name;
            games = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }

        public List<Game> getGames() {
            return games;
        }

        public void addGame(Game game) {
            games.add(game);
        }

        public void removeGame(Game game) {
            games.remove(game);
        }

}
