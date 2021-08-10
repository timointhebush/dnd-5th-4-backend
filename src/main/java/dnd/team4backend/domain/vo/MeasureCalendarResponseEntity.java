package dnd.team4backend.domain.vo;

import java.util.List;

public class MeasureCalendarResponseEntity extends BasicResponseEntity{
    private List<MeasureCalendarResponse> measures;

    public MeasureCalendarResponseEntity(Integer status, String msg, List<MeasureCalendarResponse> measures) {
        super(status, msg);
        this.measures = measures;
    }

    public List<MeasureCalendarResponse> getMeasures() {
        return measures;
    }
}
