package tech.enspd.enspdbiblio.repository;

import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;
import tech.enspd.enspdbiblio.entities.Documents;

public interface DocumentsRepository extends JpaRepository<Documents, Integer> {
}
