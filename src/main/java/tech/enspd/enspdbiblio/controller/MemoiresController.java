package tech.enspd.enspdbiblio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.enspd.enspdbiblio.entities.Memoires;
import tech.enspd.enspdbiblio.service.MemoiresService;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "memoires")
public class MemoiresController {
    
    @Autowired
    private MemoiresService memoiresService;

    // Endpoint pour récupérer tous les memoires

    @GetMapping
    public List<Memoires> getAllMemoires() {
        return memoiresService.getAllMemoires();
    }

    // Endpoint pour récupérer un memoires par son ID
    @GetMapping("/{id}")
    public Memoires getMemoireById(@PathVariable int id) {
        return memoiresService.getMemoiresById(id);
    }

    // Endpoint pour créer un nouvel memoire
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public Memoires createMemoires(@RequestBody Memoires memoires) {
        return memoiresService.createMemoires(memoires);
    }

    // Endpoint pour mettre à jour un memoire existant
    @PutMapping("/{id}")
    public Memoires updateMemoires(@PathVariable int id, @RequestBody Memoires memoiresDetails) {
        return memoiresService.updateMemoires(id, memoiresDetails);
    }

    // Endpoint pour supprimer un memoire par son ID
    @DeleteMapping("/{id}")
    public void deleteMemoires(@PathVariable int id) {
        memoiresService.deleteMemoires(id);
    }
}
