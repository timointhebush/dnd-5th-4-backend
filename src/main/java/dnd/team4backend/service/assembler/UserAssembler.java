package dnd.team4backend.service.assembler;

import dnd.team4backend.domain.User;
import dnd.team4backend.domain.vo.UserResponse;

public class UserAssembler {
    public static UserResponse toDto(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getGender().toString(),
                user.getConstitution().toString()
        );
    }
}
