package tech.enspd.enspdbiblio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.enspd.enspdbiblio.entities.Memoires;
import tech.enspd.enspdbiblio.repository.MemoiresRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MemoiresService {
    @Autowired
    private  MemoiresRepository memoiresRepository;
    public List<Memoires> getAllMemoires() {
        return memoiresRepository.findAll();
    }

    public Memoires getMemoiresById(int id) {
        Optional<Memoires> memoires = memoiresRepository.findById(id);
        return memoires.orElse(null);
    }

    public Memoires createMemoires(Memoires memoires) {
        return memoiresRepository.save(memoires);
    }

    public Memoires updateMemoires(int id, Memoires memoiresDetails) {
        Optional<Memoires> mem = memoiresRepository.findById(id);
        if (mem.isPresent()) {
            Memoires updatedMemoires = mem.get();
            // Mise à jour des champs nécessaires ici
            return memoiresRepository.save(updatedMemoires);
        }
        return null;
    }

    public void deleteMemoires(int id) {
        memoiresRepository.deleteById(id);
    }


}
