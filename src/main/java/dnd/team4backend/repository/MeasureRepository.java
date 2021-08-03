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
        if (measure.getId() == null) {
            em.persist(measure);
        } else {
            em.merge(measure);
        }
    }

    public Measure findOne(Long id) {
        return em.find(Measure.class, id);
    }
}
