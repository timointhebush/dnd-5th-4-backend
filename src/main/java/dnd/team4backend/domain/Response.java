package dnd.team4backend.domain;

import java.util.List;

public class Response {
    private final Integer status;
    private final String msg;
    private final List<MeasureResponse> measures;

    public Response(Integer status, String msg, List<MeasureResponse> measures) {
        this.status = status;
        this.msg = msg;
        this.measures = measures;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public List<MeasureResponse> getMeasures() {
        return measures;
    }
}
