package tech.enspd.enspdbiblio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import tech.enspd.enspdbiblio.dto.AuthentificationDTO;
import tech.enspd.enspdbiblio.entities.Utilisateurs;
import tech.enspd.enspdbiblio.securite.JwtService;
import tech.enspd.enspdbiblio.service.UtilisateursService;

import java.util.List;
import java.util.Map;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "utilisateurs")
public class UtilisateursController {

    private AuthenticationManager authenticationManager;
    private UtilisateursService utilisateurService;
    private JwtService jwtService;



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

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String userEndpoint() {
        return "This is a user endpoint!";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminEndpoint() {
        return "This is an admin endpoint!";
    }

    @PostMapping(path = "connexion")
    public Map<String, String> connexion(@RequestBody AuthentificationDTO authentificationDTO) {
        final Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authentificationDTO.nom(), authentificationDTO.matricule())
        );

        if(authenticate.isAuthenticated()) {
            return this.jwtService.generate(authentificationDTO.nom());
        }
        return null;
    }

}
