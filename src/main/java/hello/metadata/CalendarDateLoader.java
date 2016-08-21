package hello.metadata;

import hello.dao.Repository;
import hello.model.CalendarDate;
import org.springframework.stereotype.Component;

@Component
public class CalendarDateLoader extends DbLoaderImpl<CalendarDate> {
    public CalendarDateLoader(Repository<CalendarDate> repo, Parser<CalendarDate> parser) {
        super(repo, parser);
    }
}
