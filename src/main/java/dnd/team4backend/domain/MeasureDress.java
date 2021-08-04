package dnd.team4backend.domain;

import javax.persistence.*;

@Entity
public class MeasureDress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "measure_dress_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "measure_id")
    private Measure measure;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dress_id")
    private Dress dress;

    @Enumerated(EnumType.STRING)
    private Mood partialMood;

    public Long getId() {
        return id;
    }

    public Measure getMeasure() {
        return measure;
    }

    public Dress getDress() {
        return dress;
    }

    public Mood getPartialMood() {
        return partialMood;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }

    public void setDress(Dress dress) {
        this.dress = dress;
    }

    public void setPartialMood(Mood partialMood) {
        this.partialMood = partialMood;
    }

    public static MeasureDress createMeasureDress(Dress dress, Mood partialMood) {
        MeasureDress measureDress = new MeasureDress();
        measureDress.setDress(dress);
        measureDress.setPartialMood(partialMood);

        return measureDress;
    }
}
