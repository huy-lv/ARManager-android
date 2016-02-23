package com.example.huylv.armanager.model;

/**
 * Created by huylv on 23-Feb-16.
 */
public class PostMarker {
    String name;
    PostImage image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PostImage getImage() {
        return image;
    }

    public void setImage(PostImage image) {
        this.image = image;
    }

    public PostMarker(String name, PostImage image) {

        this.name = name;
        this.image = image;
    }
}
