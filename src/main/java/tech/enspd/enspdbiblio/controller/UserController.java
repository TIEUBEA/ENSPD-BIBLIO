package tech.enspd.enspdbiblio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.enspd.enspdbiblio.entities.User;
import tech.enspd.enspdbiblio.service.UserDetailsService;
import tech.enspd.enspdbiblio.service.UserService;

import javax.annotation.security.RolesAllowed;
import java.nio.file.AccessDeniedException;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @RolesAllowed("ROLE_ADMIN")
    @PostMapping(path = "/admin/add-user", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addUser(@RequestBody User user) throws AccessDeniedException {
        userService.createUser(user);

        return ResponseEntity.ok("User added successfully");
    }

    @GetMapping(path = "list")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping(path = "/connexion")
    public String login(String email, String matricule) {
        // Appele le service de connexion
        User user = userService.login(email, matricule);

        // Renvoie l'utilisateur connecté
        if (user != null) {
            return "L'utilisateur " + user.getEmail() + " est connecté";
        } else {
            return "L'utilisateur n'a pas été trouvé";
        }
    }
}
