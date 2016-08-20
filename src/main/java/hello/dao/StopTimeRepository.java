package hello.dao;

import hello.model.StopTime;
import org.springframework.data.repository.CrudRepository;

public interface StopTimeRepository extends CrudRepository<StopTime, Long> {
}
