package dnd.team4backend.repository;

import dnd.team4backend.domain.Dress;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class DressRepository {
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
