package tech.enspd.enspdbiblio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.enspd.enspdbiblio.entities.Memoire;
import tech.enspd.enspdbiblio.entities.User;

import java.util.List;

public interface MemoireRepository extends JpaRepository<Memoire, Long> {
    List<Memoire> findByFiliereAndAnnee(String filiere, Integer annee);
}
