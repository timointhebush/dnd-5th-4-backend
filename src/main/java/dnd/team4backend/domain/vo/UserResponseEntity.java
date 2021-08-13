package dnd.team4backend.domain.vo;

public class UserResponseEntity extends BasicResponseEntity {
    private final UserResponse userResponse;

    public UserResponseEntity(Integer status, String msg, UserResponse userResponse) {
        super(status, msg);
        this.userResponse = userResponse;
    }

    public UserResponse getUserResponse() {
        return userResponse;
    }
}
