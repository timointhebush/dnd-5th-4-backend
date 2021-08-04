package dnd.team4backend.controller;

import dnd.team4backend.domain.DressType;
import dnd.team4backend.domain.Mood;

public class MeasureDressForm {
    private Long id;
    private String userId;
    private String name;
    private DressType type;
    private Mood partialMood;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DressType getType() {
        return type;
    }

    public void setType(DressType type) {
        this.type = type;
    }

    public Mood getPartialMood() {
        return partialMood;
    }

    public void setPartialMood(Mood partialMood) {
        this.partialMood = partialMood;
    }
}
