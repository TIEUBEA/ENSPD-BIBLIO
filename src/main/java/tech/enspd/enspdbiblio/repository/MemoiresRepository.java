package tech.enspd.enspdbiblio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.enspd.enspdbiblio.entities.Memoires;

public interface MemoiresRepository extends JpaRepository<Memoires, Integer> {
}
