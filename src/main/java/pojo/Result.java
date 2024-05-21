package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("name")
    private String name;
    @JsonProperty("background_image")
    private String backgroundImage;
    @JsonProperty("released")
    private String released;

    public String getReleased() { return released; }
    public String getName() { return name; }
    public String getBackgroundImage() { return backgroundImage; }
    
}
