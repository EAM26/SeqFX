package org.example.seqfx.model;

import java.util.List;

public class Sequence {

    private Long id;
    private String name;
    private List<Scene> scenes;
    private List<View> views;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Scene> getScenes() {
        return scenes;
    }

    public void setScenes(List<Scene> scenes) {
        this.scenes = scenes;
    }

    public List<View> getViews() {
        return views;
    }

    public void setViews(List<View> views) {
        this.views = views;
    }

    public Sequence(Long id, String name) {
        this.id =id;
        this.name = name;
    }


}
