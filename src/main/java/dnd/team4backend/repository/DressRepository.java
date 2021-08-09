package dnd.team4backend.repository;

import dnd.team4backend.domain.Dress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DressRepository extends JpaRepository<Dress, Long> {
    
}
