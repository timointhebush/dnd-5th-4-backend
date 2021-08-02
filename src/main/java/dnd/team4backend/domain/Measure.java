package dnd.team4backend.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Measure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "measure_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime date;

    private String tempInfo;

    private Float temperatureHigh;

    private Float temperatureLow;

    private Float humidity;

    private String area;

    @Enumerated(EnumType.STRING)
    private Mood mood; // VERYHOT, HOT, GOOD, COLD, VERYCOLD

    private String comment;

    @OneToMany(mappedBy = "measure")
    private List<MeasureDress> measureDressList;

    public void addMeasureDress(MeasureDress measureDress) {
        measureDressList.add(measureDress);
        measureDress.setMeasure(this);
    }

    public void setUser(User user) {
        this.user = user;
    }

    //==생성 메서드==//
    public static Measure createMeasure(User user, LocalDateTime date, String tempInfo, Float temperatureHigh,
                                        Float temperatureLow, Float humidity, String area, Mood mood,
                                        String comment, MeasureDress... measureDresses) {
        Measure measure = new Measure();
        measure.setUser(user);
        measure.date = date;
        measure.tempInfo = tempInfo;
        measure.temperatureHigh = temperatureHigh;
        measure.temperatureLow = temperatureLow;
        measure.humidity = humidity;
        measure.area = area;
        measure.mood = mood;
        measure.comment = comment;
        for (MeasureDress measureDress : measureDresses) {
            measure.addMeasureDress(measureDress);
        }
        return measure;
    }


    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getTempInfo() {
        return tempInfo;
    }

    public Float getTemperatureHigh() {
        return temperatureHigh;
    }

    public Float getTemperatureLow() {
        return temperatureLow;
    }

    public Float getHumidity() {
        return humidity;
    }

    public String getArea() {
        return area;
    }

    public Mood getMood() {
        return mood;
    }

    public String getComment() {
        return comment;
    }

    public List<MeasureDress> getMeasureDressList() {
        return measureDressList;
    }
}
