package dnd.team4backend.service;

import dnd.team4backend.domain.Constitution;
import dnd.team4backend.domain.Gender;
import dnd.team4backend.domain.User;
import dnd.team4backend.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Test
    void 회원등록테스트() throws Exception {
        //given
        User user = new User();
        user.addBasicInfo("testId1", "Kim", Gender.M, 18, Constitution.HOT);

        //when
        String savedId = userService.join(user);
        //then
        Assertions.assertEquals(user, userRepository.findOne(savedId));
    }

    @Test
    public void 회원_아이디_중복테스트() throws Exception {
        //given
        User user1 = new User();
        user1.addBasicInfo("testId1", "Kim", Gender.M, 18, Constitution.HOT);

        User user2 = new User();
        user2.addBasicInfo("testId1", "Lee", Gender.W, 20, Constitution.COLD);
        //when
        userService.join(user1);
        try {
            userService.join(user2);
        } catch (IllegalStateException e) {
            return;
        }
        //then
        Assertions.fail("예외 발생해야함");
    }

    @Test
    public void 회원_닉네임_중복테스트() throws Exception {
        //given
        User user1 = new User();
        user1.addBasicInfo("testId1", "Kim", Gender.M, 18, Constitution.HOT);

        User user2 = new User();
        user2.addBasicInfo("testId2", "Kim", Gender.W, 20, Constitution.COLD);

        userService.join(user1);
        //when

        boolean result = userService.isExistedNickName(user2.getName());

        //then
        Assertions.assertEquals(true, result);
    }
}