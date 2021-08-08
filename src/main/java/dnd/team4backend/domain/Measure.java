package dnd.team4backend.domain;

import dnd.team4backend.domain.vo.MeasureVO;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Measure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "measure_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
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

    @OneToMany(mappedBy = "measure", cascade = CascadeType.ALL)
    private final List<MeasureDress> measureDressList = new ArrayList<>();

    public void addMeasureDress(MeasureDress measureDress) {
        measureDress.setMeasure(this);
        measureDressList.add(measureDress);
    }

    public void setUser(User user) {
        this.user = user;
    }

    protected Measure() {
    }

    //==생성 메서드==//
    public static Measure createMeasure(User user, LocalDateTime date, String tempInfo, Float temperatureHigh,
                                        Float temperatureLow, Float humidity, String area, Mood mood,
                                        String comment, List<MeasureDress> measureDresses) {
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

    public void modifyMeasure(MeasureVO measureVO) {
        if (measureVO.getDate() != null) {
            date = measureVO.getDate();
        }
        if (measureVO.getArea() != null) {
            area = measureVO.getArea();
        }
        if (measureVO.getComment() != null) {
            comment = measureVO.getComment();
        }
        if (measureVO.getHumidity() != null) {
            humidity = measureVO.getHumidity();
        }
        if (measureVO.getTemperatureLow() != null) {
            temperatureLow = measureVO.getTemperatureLow();
        }
        if (measureVO.getTemperatureHigh() != null) {
            temperatureHigh = measureVO.getTemperatureHigh();
        }
        if (measureVO.getTempInfo() != null) {
            tempInfo = measureVO.getTempInfo();
        }
        if (measureVO.getMood() != null) {
            mood = measureVO.getMood();
        }
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
