package dnd.team4backend.domain.vo;

import java.time.LocalDateTime;
import java.util.List;

public class MeasureResponse {
    private final Long measureId;
    private final String userId;
    private final String userName;
    private final String userConstitution;
    private final LocalDateTime date;
    private final String tempInfo;
    private final Float temperatureHigh;
    private final Float temperatureLow;
    private final Float humidity;
    private final String area;
    private final String mood;
    private final String comment;
    private final List<DressResponse> dressResponses;

    public MeasureResponse(Long measureId, String userId, String userName, String userConstitution, LocalDateTime date, String tempInfo, Float temperatureHigh, Float temperatureLow, Float humidity, String area, String mood, String comment, List<DressResponse> dressResponses) {
        this.measureId = measureId;
        this.userId = userId;
        this.userName = userName;
        this.userConstitution = userConstitution;
        this.date = date;
        this.tempInfo = tempInfo;
        this.temperatureHigh = temperatureHigh;
        this.temperatureLow = temperatureLow;
        this.humidity = humidity;
        this.area = area;
        this.mood = mood;
        this.comment = comment;
        this.dressResponses = dressResponses;
    }

    public Long getMeasureId() {
        return measureId;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserConstitution() {
        return userConstitution;
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

    public String getMood() {
        return mood;
    }

    public String getComment() {
        return comment;
    }

    public List<DressResponse> getDressResponses() {
        return dressResponses;
    }
}
