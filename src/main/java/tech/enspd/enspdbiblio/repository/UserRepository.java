package tech.enspd.enspdbiblio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.enspd.enspdbiblio.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByMatricule(String matricule);

    User findByEmail(String username);

    User findByEmailAndMatricule(String email, String matricule);
}
