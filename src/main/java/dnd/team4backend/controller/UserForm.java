package dnd.team4backend.controller;


import dnd.team4backend.domain.Constitution;
import dnd.team4backend.domain.Gender;

public class UserForm {
    private String name;
    private Gender gender;
    private Integer age;
    private Constitution constitution;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Constitution getConstitution() {
        return constitution;
    }

    public void setConstitution(Constitution constitution) {
        this.constitution = constitution;
    }
}
