package tech.enspd.enspdbiblio.repository;

import org.springframework.data.repository.CrudRepository;
import tech.enspd.enspdbiblio.entities.Validation;


import java.util.Optional;

public interface ValidationRepository extends CrudRepository<Validation, Integer> {

    Optional<Validation> findByCode(String code);
}
