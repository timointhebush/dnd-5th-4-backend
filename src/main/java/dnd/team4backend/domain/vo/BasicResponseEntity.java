package dnd.team4backend.domain.vo;

public class BasicResponseEntity {
    private final Integer status;
    private final String msg;

    public BasicResponseEntity(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

}
