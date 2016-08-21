package hello.metadata;

import hello.dao.Repository;
import hello.model.Calendar;
import org.springframework.stereotype.Component;

@Component
public class CalendarLoader extends DbLoaderImpl<Calendar> {
    public CalendarLoader(Repository<Calendar> repo, Parser<Calendar> parser) {
        super(repo, parser);
    }
}
