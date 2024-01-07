package tech.enspd.enspdbiblio.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.enspd.enspdbiblio.entities.Memoire;
import tech.enspd.enspdbiblio.service.MemoireService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "memoire")
public class MemoireController {

    private final MemoireService memoireService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void ajouterMemoire (@RequestBody Memoire memoire){
        this.memoireService.ajouterMemoire(memoire);
    }

    @GetMapping
    public List<Memoire> liste() {
        return this.memoireService.liste();
    }

    @GetMapping("/recherche")
    public ResponseEntity<List<Memoire>> rechercherMemoire(
            @RequestParam(required = false) String nom,
            @RequestParam(required = false) String filiere,
            @RequestParam(required = false) Integer annee
    ) {
        List<Memoire> result = memoireService.rechercherMemoire(nom, filiere, (annee != null) ? annee : 0);

        if (result.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(result);
    }
}
