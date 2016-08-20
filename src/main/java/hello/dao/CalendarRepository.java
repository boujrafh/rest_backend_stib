package hello.dao;

import hello.model.Calendar;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CalendarRepository {
    void save(List<Calendar> calendars);
    Calendar getReference(String id);
}
