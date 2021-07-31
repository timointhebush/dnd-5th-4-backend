package dnd.team4backend.service;

import dnd.team4backend.domain.User;
import dnd.team4backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //회원 등록
    public String join(User user) {
        validateDuplicateUser(user);
        userRepository.save(user);
        return user.getId();
    }
    
    private void validateDuplicateUser(User user) {
        User findUser = userRepository.findOne(user.getId());
        if (findUser != null) {
            throw new IllegalStateException("이미 존재하는 회원 입니다.");
        }
    }


}
