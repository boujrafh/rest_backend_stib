package hello.metadata;

import hello.model.Calendar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public class CalendarLoader extends DbLoaderImpl<Calendar> {

    public CalendarLoader(CrudRepository<Calendar, Long> repo, Parser<Calendar> parser) {
        super(repo, parser);
    }
}
