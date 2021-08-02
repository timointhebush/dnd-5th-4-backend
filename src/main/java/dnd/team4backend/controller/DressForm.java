package dnd.team4backend.controller;

import dnd.team4backend.domain.DressType;

public class DressForm {
    private String userId;
    private String dressName;
    private DressType dressType;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDressName() {
        return dressName;
    }

    public void setDressName(String dressName) {
        this.dressName = dressName;
    }

    public DressType getDressType() {
        return dressType;
    }

    public void setDressType(DressType dressType) {
        this.dressType = dressType;
    }
}
