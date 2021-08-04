package dnd.team4backend.repository;

import dnd.team4backend.domain.Measure;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MeasureRepository {

    @PersistenceContext
    private final EntityManager em;

    public MeasureRepository(EntityManager em) {
        this.em = em;
    }

    public void save(Measure measure) {
        // merge는 전부다 갈아 엎는다
        // 따라서 일부만 변경하고 싶을때는 변경감지를 이용한다.
        em.persist(measure);
    }

    public Measure findOne(Long id) {
        return em.find(Measure.class, id);
    }
}
