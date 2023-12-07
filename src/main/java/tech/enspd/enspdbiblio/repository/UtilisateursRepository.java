package tech.enspd.enspdbiblio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.enspd.enspdbiblio.entities.Utilisateurs;

public interface UtilisateursRepository extends JpaRepository<Utilisateurs, Integer> {
}
