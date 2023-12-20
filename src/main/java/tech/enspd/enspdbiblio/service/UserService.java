package tech.enspd.enspdbiblio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import tech.enspd.enspdbiblio.entities.User;
import tech.enspd.enspdbiblio.repository.UserRepository;

import java.nio.file.AccessDeniedException;
import java.util.List;

@Service

public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDetailsService userDetailsService;


    public User createUser(User user) throws AccessDeniedException {
        // Charge les informations d'identification de l'utilisateur
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getMatricule());

        // Vérifie le rôle de l'utilisateur
        if (!userDetails.getAuthorities().contains("ROLE_ADMIN")) {
            throw new AccessDeniedException("Vous n'êtes pas autorisé à ajouter des utilisateurs");
        }

        // Crée un objet User
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setMatricule(user.getMatricule());
        newUser.setRole(userDetails.getAuthorities().toString());

        return userRepository.save(newUser);
    }

    public User login(String email, String matricule) {
        // Vérifie que les informations d'identification sont correctes
        User user = userRepository.findByEmailAndMatricule(email, matricule);
        if (user == null) {
            return null;
        }

        // Renvoie l'utilisateur
        return user;
    }



    public List<User> findAll() {
        return userRepository.findAll();
    }


}
