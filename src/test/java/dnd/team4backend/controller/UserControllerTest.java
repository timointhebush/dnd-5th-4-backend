package dnd.team4backend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void Profile확인() {
        // given
        // when
        String profile = restTemplate.getForObject("/profile", String.class);
        // then
        assertThat(profile).isEqualTo("local");
    }
}
