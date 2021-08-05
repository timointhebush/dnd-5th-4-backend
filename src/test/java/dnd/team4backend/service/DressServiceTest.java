package dnd.team4backend.service;

import dnd.team4backend.domain.*;
import dnd.team4backend.repository.DressRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class DressServiceTest {

    @Autowired
    DressRepository dressRepository;

    @Autowired
    DressService dressService;

    @Test
    public void 옷_저장_테스트() {
        // given
        User user = new User();
        user.addBasicInfo("abcd", "junseok", Gender.M, Constitution.HOT);
        Dress dress = Dress.createDress(user, "나이키 반바지", DressType.BOTTOM);

        // when
        dressService.saveDress(dress);
        Dress findDress = dressService.findOne(dress.getId());

        // then
        Assertions.assertEquals(dress, findDress);
    }
}
