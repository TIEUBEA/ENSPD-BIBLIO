package tech.enspd.enspdbiblio.controller;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import tech.enspd.enspdbiblio.dto.AuthentificationDTO;
import tech.enspd.enspdbiblio.entities.User;
import tech.enspd.enspdbiblio.securite.JwtService;
import tech.enspd.enspdbiblio.service.UserService;

import java.util.List;
import java.util.Map;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private AuthenticationManager authenticationManager;
    private UserService userService;
    private JwtService jwtService;

    @PostMapping(path = "inscription")
    public void inscription(@RequestBody User user) {
        log.info("Inscription");
        this.userService.inscription(user);
    }

    @PostMapping(path = "activation")
    public void activation(@RequestBody Map<String, String> activation) {
        this.userService.activation(activation);
    }

    @PostMapping(path = "deconnexion")
    public void deconnexion() {
        this.jwtService.deconnxion();
    }

    @PostMapping(path = "connexion")
    public Map<String, String> connexion(@RequestBody AuthentificationDTO authentificationDTO) {
        final Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authentificationDTO.username(), authentificationDTO.password())
        );

        if(authenticate.isAuthenticated()) {
            return this.jwtService.generate(authentificationDTO.username());
        }
        return null;
    }

    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR)")
    @GetMapping(path = "/liste des utilisateurs")
    public List<User> liste() {
        return this.userService.liste();
    }

}
