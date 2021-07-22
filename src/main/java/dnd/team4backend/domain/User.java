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

    private Integer age;

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

    public Integer getAge() {
        return age;
    }

    public List<Measure> getMeasureList() {
        return measureList;
    }

    public List<Dress> getDressList() {
        return dressList;
    }
}
