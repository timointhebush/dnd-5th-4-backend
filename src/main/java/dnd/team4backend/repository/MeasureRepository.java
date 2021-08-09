package dnd.team4backend.repository;

import dnd.team4backend.domain.Measure;
import dnd.team4backend.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MeasureRepository extends JpaRepository<Measure, Long> {
    /**
     * 특정 유저의 평가 중, 해당 날씨 데이터와 유사한
     * 평가들을 조회
     */
    @Query("select m from Measure m where m.id < ?1 and m.user = ?2 and (m.temperatureHigh between ?3 and ?4 or m.temperatureLow between ?5 and ?6 or m.humidity between ?7 and ?8) order by m.id desc")
    Page<Measure> findByWeatherOfUser(Long measureId, User user, Float tempHigh1, Float tempHigh2, Float tempLow1, Float tempLow2, Float humid1, Float humid2, Pageable pageable);

    /**
     * 특정 유저를 제외한 평가 중, 해당 날씨 데이터와 유사한
     * 평가들을 Id역순으로 조회,
     */
    @Query("select m from Measure m where m.id < ?1 and m.user <> ?2 and (m.temperatureHigh between ?3 and ?4 or m.temperatureLow between ?5 and ?6 or m.humidity between ?7 and ?8) order by m.id desc")
    Page<Measure> findByWeatherOfOthers(Long measureId, User user, Float tempHigh1, Float tempHigh2, Float tempLow1, Float tempLow2, Float humid1, Float humid2, Pageable pageable);
}
