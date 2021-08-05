package dnd.team4backend.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class DressTest {

    @Test
    public void Dress_Entity_생성테스트() throws Exception {
        //given
        User user = new User();
        user.addBasicInfo("abcd", "junseok", Gender.M, Constitution.HOT);

        //when
        Dress dress = Dress.createDress(user, "나이키 반바지", DressType.BOTTOM);

        //then
        Assertions.assertEquals("나이키 반바지", dress.getDressName());
        Assertions.assertEquals(user, dress.getUser());
    }

}
