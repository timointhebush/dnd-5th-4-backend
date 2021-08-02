package dnd.team4backend.service;

import dnd.team4backend.domain.Dress;
import dnd.team4backend.repository.DressRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class DressService {
    private final DressRepository dressRepository;

    public DressService(DressRepository dressRepository) {
        this.dressRepository = dressRepository;
    }

    @Transactional
    public void saveDress(Dress dress) {
        dressRepository.save(dress);
    }

    public Dress findOne(Long dressId) {
        return dressRepository.findOne(dressId);
    }
}
