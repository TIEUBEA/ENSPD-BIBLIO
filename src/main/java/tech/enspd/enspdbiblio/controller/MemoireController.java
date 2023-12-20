package tech.enspd.enspdbiblio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.enspd.enspdbiblio.entities.Memoire;
import tech.enspd.enspdbiblio.repository.MemoireRepository;

import java.util.List;

@RestController
@RequestMapping(path = "memoires")
public class MemoireController {
    @Autowired
    private MemoireRepository memoireRepository;

    @PostMapping
    public ResponseEntity<Memoire> createMemoire(@RequestBody Memoire memoire) {
        return ResponseEntity.ok(memoireRepository.save(memoire));
    }

    @GetMapping
    public List<Memoire> getAllMemoires() {
        return memoireRepository.findAll();
    }

    @GetMapping("/search")
    public List<Memoire> searchMemoires(@RequestParam(name = "filiere") String filiere, @RequestParam(name = "annee") Integer annee) {
        return memoireRepository.findByFiliereAndAnnee(filiere, annee);
    }
}
