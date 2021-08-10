package dnd.team4backend.domain.vo;

import java.time.LocalDateTime;

public class MeasureCalendarResponse {
    private Long measureId;
    private String userId;
    private LocalDateTime dateTime;
    private Float temperatureHigh;
    private Float temperatureLow;
    private Float humidity;
    private String mood;

    public MeasureCalendarResponse(Long measureId, String userId, LocalDateTime dateTime, Float temperatureHigh, Float temperatureLow, Float humidity, String mood) {
        this.measureId = measureId;
        this.userId = userId;
        this.dateTime = dateTime;
        this.temperatureHigh = temperatureHigh;
        this.temperatureLow = temperatureLow;
        this.humidity = humidity;
        this.mood = mood;
    }

    public Long getMeasureId() {
        return measureId;
    }

    public String getUserId() {
        return userId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
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

    public String getMood() {
        return mood;
    }
}
