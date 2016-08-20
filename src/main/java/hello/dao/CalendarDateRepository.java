package hello.dao;

import hello.model.CalendarDate;
import org.springframework.data.repository.CrudRepository;

public interface CalendarDateRepository extends CrudRepository<CalendarDate, Long> {
}
