package dnd.team4backend.domain;

import javax.persistence.*;

@Entity
public class Dress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dress_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String dressName;

    @Enumerated(EnumType.STRING)
    private DressType dressType; // TOP, BOTTOM, OUTER, SHOES, ETC


    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getDressName() {
        return dressName;
    }

    public DressType getDressType() {
        return dressType;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //==생성 메서드==//
    public static Dress createDress(User user, String dressName, DressType dressType) {
        Dress dress = new Dress();
        dress.dressName = dressName;
        dress.dressType = dressType;
        user.addDress(dress);
        return dress;
    }
}
