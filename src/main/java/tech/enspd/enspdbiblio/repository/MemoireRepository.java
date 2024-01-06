package tech.enspd.enspdbiblio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tech.enspd.enspdbiblio.entities.Memoire;
import tech.enspd.enspdbiblio.entities.User;

import java.util.List;

public interface MemoireRepository extends CrudRepository<Memoire, Integer> {

}
