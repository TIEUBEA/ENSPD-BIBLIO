package tech.enspd.enspdbiblio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.enspd.enspdbiblio.entities.Utilisateurs;

import java.util.Optional;

public interface UtilisateursRepository extends JpaRepository<Utilisateurs, Integer> {
    Optional<Utilisateurs> findByMatricule(String matricule);
}
