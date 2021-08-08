package dnd.team4backend.domain;

public class DressResponse {
    private final Long dressId;
    private final String dressName;
    private final String dressType;
    private final String partialMood;

    public DressResponse(Long dressId, String dressName, String dressType, String partialMood) {
        this.dressId = dressId;
        this.dressName = dressName;
        this.dressType = dressType;
        this.partialMood = partialMood;
    }

    public Long getDressId() {
        return dressId;
    }

    public String getDressName() {
        return dressName;
    }

    public String getDressType() {
        return dressType;
    }

    public String getPartialMood() {
        return partialMood;
    }
}
