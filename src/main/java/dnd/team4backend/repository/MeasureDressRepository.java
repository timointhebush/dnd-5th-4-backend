package dnd.team4backend.repository;

import dnd.team4backend.domain.MeasureDress;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MeasureDressRepository {

    @PersistenceContext
    private final EntityManager em;

    public MeasureDressRepository(EntityManager em) {
        this.em = em;
    }

    public MeasureDress findOne(Long id) {
        return em.find(MeasureDress.class, id);
    }

}
