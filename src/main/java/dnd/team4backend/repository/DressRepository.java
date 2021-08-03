package dnd.team4backend.repository;

import dnd.team4backend.domain.Dress;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class DressRepository {
    @PersistenceContext
    private final EntityManager em;

    public DressRepository(EntityManager em) {
        this.em = em;
    }

    public void save(Dress dress) {
        if (dress.getId() == null) {
            em.persist(dress);
        } else {
            em.merge(dress);
        }
    }

    public Dress findOne(Long id) {
        return em.find(Dress.class, id);
    }
}
