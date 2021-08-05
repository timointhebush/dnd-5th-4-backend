package dnd.team4backend.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @Column(name = "user_id")
    private String id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender; // M,W


    @Enumerated(EnumType.STRING)
    private Constitution constitution; // HOT(더위 많이 탐), COLD(추위 많이 탐)


    @OneToMany(mappedBy = "user")
    private final List<Measure> measureList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private final List<Dress> dressList = new ArrayList<>();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }


    public List<Measure> getMeasureList() {
        return measureList;
    }

    public List<Dress> getDressList() {
        return dressList;
    }

    public void addMeasure(Measure measure) {
        measureList.add(measure);
        measure.setUser(this);
    }

    public void addDress(Dress dress) {
        dressList.add(dress);
        dress.setUser(this);
    }

    public void addBasicInfo(String id, String name, Gender gender, Constitution constitution) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.constitution = constitution;
    }
}
