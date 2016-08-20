package hello.metadata;

import hello.dao.CalendarDateRepository;
import hello.model.CalendarDate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public class CalendarDateLoader extends DbLoaderImpl<CalendarDate> {
    public CalendarDateLoader(CalendarDateRepository repo, Parser<CalendarDate> parser) {
        super(repo, parser);
    }
}
