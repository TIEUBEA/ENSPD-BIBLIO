package tech.enspd.enspdbiblio.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.enspd.enspdbiblio.entities.Memoire;
import tech.enspd.enspdbiblio.repository.MemoireRepository;

@AllArgsConstructor
@Service
public class MemoireService {

    private final MemoireRepository memoireRepository;

    public void creer (Memoire memoire){
        this.memoireRepository.save(memoire);
    }
}
