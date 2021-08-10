package dnd.team4backend.domain.vo;

import java.util.List;

public class MeasureResponseEntity extends BasicResponseEntity {
    private List<MeasureResponse> measures;

    public MeasureResponseEntity(Integer status, String msg, List<MeasureResponse> measures) {
        super(status, msg);
        this.measures = measures;
    }

    public List<MeasureResponse> getMeasures() {
        return measures;
    }
}

