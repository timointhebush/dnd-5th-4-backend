package dnd.team4backend.domain.vo;

public class UserResponse {

    private final String id;

    private final String name;

    private final String gender;

    private final String constitution;


    public UserResponse(String id, String name, String gender, String constitution) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.constitution = constitution;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getConstitution() {
        return constitution;
    }
    
}
