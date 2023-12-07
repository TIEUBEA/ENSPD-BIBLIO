package tech.enspd.enspdbiblio.controller;

import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.enspd.enspdbiblio.entities.Utilisateurs;
import tech.enspd.enspdbiblio.service.UtilisateursService;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "utilisateurs")
public class UtilisateursController {

    @Autowired
    private UtilisateursService utilisateurService; // Injection du service pour gérer les opérations sur les Utilisateurs

    // Endpoint pour récupérer tous les utilisateurs

    @GetMapping
    public List<Utilisateurs> getAllUtilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }

    // Endpoint pour récupérer un utilisateur par son ID
    @GetMapping("/{id}")
    public Utilisateurs getUtilisateurById(@PathVariable int id) {
        return utilisateurService.getUtilisateurById(id);
    }

    // Endpoint pour créer un nouvel utilisateur
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public Utilisateurs createUtilisateur(@RequestBody Utilisateurs utilisateur) {
        return utilisateurService.createUtilisateur(utilisateur);
    }

    // Endpoint pour mettre à jour un utilisateur existant
    @PutMapping("/{id}")
    public Utilisateurs updateUtilisateur(@PathVariable int id, @RequestBody Utilisateurs utilisateurDetails) {
        return utilisateurService.updateUtilisateur(id, utilisateurDetails);
    }

    // Endpoint pour supprimer un utilisateur par son ID
    @DeleteMapping("/{id}")
    public void deleteUtilisateur(@PathVariable int id) {
        utilisateurService.deleteUtilisateur(id);
    }

}
