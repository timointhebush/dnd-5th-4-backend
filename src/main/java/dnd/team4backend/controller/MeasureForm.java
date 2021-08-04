package dnd.team4backend.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import dnd.team4backend.domain.Mood;

import java.time.LocalDateTime;
import java.util.List;

public class MeasureForm {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime date;
    private Float temperatureHigh;
    private Float temperatureLow;
    private Float humidity;
    private String area;
    private String tempInfo;
    private List<MeasureDressForm> dresses;
    private Mood mood;
    private String comment;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Float getTemperatureHigh() {
        return temperatureHigh;
    }

    public void setTemperatureHigh(Float temperatureHigh) {
        this.temperatureHigh = temperatureHigh;
    }

    public Float getTemperatureLow() {
        return temperatureLow;
    }

    public void setTemperatureLow(Float temperatureLow) {
        this.temperatureLow = temperatureLow;
    }

    public Float getHumidity() {
        return humidity;
    }

    public void setHumidity(Float humidity) {
        this.humidity = humidity;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTempInfo() {
        return tempInfo;
    }

    public void setTempInfo(String tempInfo) {
        this.tempInfo = tempInfo;
    }

    public List<MeasureDressForm> getDresses() {
        return dresses;
    }

    public void setDresses(List<MeasureDressForm> dresses) {
        this.dresses = dresses;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
