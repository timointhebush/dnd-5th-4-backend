package dnd.team4backend.domain;

import java.time.LocalDateTime;

public class MeasureVO {

    private LocalDateTime date;

    private String tempInfo;

    private Float temperatureHigh;

    private Float temperatureLow;

    private Float humidity;

    private String area;

    private Mood mood; // VERYHOT, HOT, GOOD, COLD, VERYCOLD

    private String comment;

    public void createMeasureVO(LocalDateTime date, String tempInfo, Float temperatureHigh, Float temperatureLow, Float humidity, String area, Mood mood, String comment) {
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

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setTempInfo(String tempInfo) {
        this.tempInfo = tempInfo;
    }

    public void setTemperatureHigh(Float temperatureHigh) {
        this.temperatureHigh = temperatureHigh;
    }

    public void setTemperatureLow(Float temperatureLow) {
        this.temperatureLow = temperatureLow;
    }

    public void setHumidity(Float humidity) {
        this.humidity = humidity;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
