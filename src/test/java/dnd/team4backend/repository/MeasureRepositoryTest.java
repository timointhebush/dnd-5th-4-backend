package dnd.team4backend.repository;

import dnd.team4backend.domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class MeasureRepositoryTest {

    @Autowired
    MeasureRepository measureRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    DressRepository dressRepository;

    @Test
    public void 유사날씨_평가_조회_테스트() {
        // given
        User user1 = new User();
        user1.addBasicInfo("testUser1", "jun", Gender.M, Constitution.COLD);
        userRepository.save(user1);

        Dress dress1 = Dress.createDress(user1, "나이키 반바지", DressType.BOTTOM);
        Dress dress2 = Dress.createDress(user1, "칼하트 반팔", DressType.TOP);
        dressRepository.save(dress1);
        dressRepository.save(dress2);

        MeasureDress measureDress1 = MeasureDress.createMeasureDress(dress1, Mood.GOOD);
        MeasureDress measureDress2 = MeasureDress.createMeasureDress(dress2, Mood.GOOD);
        List<MeasureDress> measureDressList = new ArrayList<>();
        measureDressList.add(measureDress1);
        measureDressList.add(measureDress2);

        Measure measure1 = Measure.createMeasure(user1, LocalDateTime.now(), "구름 많음", 31.5F,
                24.3F, 15F, "서울", Mood.GOOD, "적당했다", measureDressList);
        Measure measure2 = Measure.createMeasure(user1, LocalDateTime.now(), "구름 많음", 31.4F,
                24.2F, 15.1F, "서울", Mood.GOOD, "아주 적당했다", measureDressList);

        measureRepository.save(measure1);
        measureRepository.save(measure2);

        // when
        // 최고온도, 최저온도, 습도가 비슷할때
        PageRequest pageRequest1 = PageRequest.of(0, 2);
        Page<Measure> findMeasureList = measureRepository.findByWeatherOfUser(23L, user1, 30.3F, 32.3F, 23.2F, 24.2F, 14F, 16F, pageRequest1);
        // 하나도 비슷하지않을때
        PageRequest pageRequest2 = PageRequest.of(0, 2);
        Page<Measure> emptyMeasureList = measureRepository.findByWeatherOfUser(23L, user1, 32F, 34F, 25F, 27F, 16F, 18F, pageRequest2);
        // 하나의 요소만 비슷
        PageRequest pageRequest3 = PageRequest.of(0, 2);
        Page<Measure> findMeasureList2 = measureRepository.findByWeatherOfUser(23L, user1, 32F, 34F, 25F, 27F, 14.3F, 16.3F, pageRequest3);

        // then
        List<Measure> measureList = new ArrayList<>();
        measureList.add(measure2);
        measureList.add(measure1);
        List<Measure> emptyList = new ArrayList<>();

        Assertions.assertEquals(measureList, findMeasureList.getContent());
        Assertions.assertEquals(emptyList, emptyMeasureList.getContent());
        Assertions.assertEquals(measureList, findMeasureList2.getContent());
    }

    @Test
    public void 날짜_평가_조회_테스트() {
        // given
        User user1 = new User();
        user1.addBasicInfo("testUser1", "jun", Gender.M, Constitution.COLD);
        userRepository.save(user1);

        Dress dress1 = Dress.createDress(user1, "나이키 반바지", DressType.BOTTOM);
        Dress dress2 = Dress.createDress(user1, "칼하트 반팔", DressType.TOP);
        dressRepository.save(dress1);
        dressRepository.save(dress2);

        MeasureDress measureDress1 = MeasureDress.createMeasureDress(dress1, Mood.GOOD);
        MeasureDress measureDress2 = MeasureDress.createMeasureDress(dress2, Mood.GOOD);
        List<MeasureDress> measureDressList = new ArrayList<>();
        measureDressList.add(measureDress1);
        measureDressList.add(measureDress2);

        Measure measure1 = Measure.createMeasure(user1, LocalDateTime.of(2021, 8, 2, 15, 10, 5),
                "구름 많음", 31.5F,
                24.3F, 15F, "서울", Mood.GOOD, "적당했다", measureDressList);
        Measure measure2 = Measure.createMeasure(user1, LocalDateTime.of(2021, 8, 3, 16, 15, 3),
                "구름 많음", 31.4F,
                24.2F, 15.1F, "서울", Mood.GOOD, "아주 적당했다", measureDressList);

        measureRepository.save(measure1);
        measureRepository.save(measure2);

        // when
        List<Measure> measureList = new ArrayList<>();
        measureList.add(measure1);
        measureList.add(measure2);

        LocalTime startTime = LocalTime.of(0, 0);
        LocalTime endTime = LocalTime.of(23, 59);

        LocalDate startDate = LocalDate.of(2021, 8, 1);
        LocalDate endDate = LocalDate.of(2021,8, 3);

        List<Measure> findMeasures = measureRepository.findByUserAndDateBetween(user1, LocalDateTime.of(startDate, startTime), LocalDateTime.of(endDate, endTime));

        // then
        Assertions.assertEquals(measureList, findMeasures);
    }
}
