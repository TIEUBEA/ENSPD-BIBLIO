package tech.enspd.enspdbiblio.repository;

import org.springframework.data.repository.CrudRepository;
import tech.enspd.enspdbiblio.entities.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository <User, Integer > {
    Optional<User> findByEmail(String email);
}
