package hello.dao;

import hello.model.Agency;
import org.springframework.data.repository.CrudRepository;

public interface AgencyRepositoy extends CrudRepository<Agency, Long> {
}
