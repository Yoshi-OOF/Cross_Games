package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("serial")
public class MyTags implements Serializable {

    private List<Tags> allTags;

    public MyTags() {
        super();
        allTags = new ArrayList<>();
    }

    public synchronized void addTag(Tags newTag) {
        allTags.add(newTag);
    }

    public List<Tags> getAllTags() {
        return Collections.unmodifiableList(allTags);
    }

    public synchronized void removeTag(Tags tag) {
        allTags.remove(tag);
    }

    public Optional<Tags> findTagByName(String name) {
        if (name == null || name.isEmpty()) {
            return Optional.empty();
        }
        return allTags.stream()
                .filter(tag -> name.equals(tag.getName()))
                .findFirst();
    }
}
