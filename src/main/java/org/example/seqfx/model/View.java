package org.example.seqfx.model;

import java.util.List;

public class View {

    private Long id;
    private String name;
    private Sequence sequence;
    private List<Scene> scenes;

    public View(Long id, String name, Sequence sequence) {
        this.id = id;
        this.name = name;
        this.sequence = sequence;
    }

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

    public Sequence getSequence() {
        return sequence;
    }

    public void setSequence(Sequence sequence) {
        this.sequence = sequence;
    }

    public List<Scene> getScenes() {
        return scenes;
    }

    public void setScenes(List<Scene> scenes) {
        this.scenes = scenes;
    }
}
