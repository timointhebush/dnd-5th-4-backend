package dnd.team4backend.controller;


import dnd.team4backend.domain.Constitution;
import dnd.team4backend.domain.Gender;

public class UserForm {
    private String userId;
    private String name;
    private Gender gender;
    private Constitution constitution;

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }


    public Constitution getConstitution() {
        return constitution;
    }

    public void setConstitution(Constitution constitution) {
        this.constitution = constitution;
    }
}
