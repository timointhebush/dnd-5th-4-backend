package dnd.team4backend.domain;

public class DressVO {

    private final Long id;
    private final String name;
    private final DressType dressType;
    private final Mood partialMood;

    public DressVO(Long id, String userId, String name, DressType dressType, Mood partialMood) {
        this.id = id;
        this.name = name;
        this.dressType = dressType;
        this.partialMood = partialMood;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public DressType getDressType() {
        return dressType;
    }

    public Mood getPartialMood() {
        return partialMood;
    }
}
