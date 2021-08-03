package dnd.team4backend.domain;

import java.time.LocalDateTime;

public class MeasureVO {

    private final LocalDateTime date;

    private final String tempInfo;

    private final Float temperatureHigh;

    private final Float temperatureLow;

    private final Float humidity;

    private final String area;

    private final Mood mood; // VERYHOT, HOT, GOOD, COLD, VERYCOLD

    private final String comment;

    public MeasureVO(LocalDateTime date, String tempInfo, Float temperatureHigh, Float temperatureLow, Float humidity, String area, Mood mood, String comment) {
        this.date = date;
        this.tempInfo = tempInfo;
        this.temperatureHigh = temperatureHigh;
        this.temperatureLow = temperatureLow;
        this.humidity = humidity;
        this.area = area;
        this.mood = mood;
        this.comment = comment;
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
}
