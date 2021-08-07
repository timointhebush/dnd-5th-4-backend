package dnd.team4backend.repository;

import dnd.team4backend.domain.Measure;
import dnd.team4backend.domain.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MeasureRepository extends JpaRepository<Measure, Long> {
    /**
     * 특정 유저의 평가 중, 해당 날씨 데이터와 유사한
     * 평가들을 조회
     */
    List<Measure> findByUserAndTemperatureHighBetweenOrTemperatureLowBetweenOrHumidityBetween(User user, Float tempHigh1, Float tempHigh2, Float tempLow1, Float tempLow2, Float humid1, Float humid2);

    @Override
    <S extends Measure> Optional<S> findOne(Example<S> example);
}
