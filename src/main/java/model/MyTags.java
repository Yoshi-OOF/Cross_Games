package model;

import java.util.List;

public class MyTags {

        private String name;
        private List<Game> games;

        public MyTags() {
            super();
            this.name = "";
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
}
