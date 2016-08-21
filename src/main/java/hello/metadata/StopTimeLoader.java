package hello.metadata;

import hello.dao.Repository;
import hello.model.StopTime;
import org.springframework.stereotype.Component;

@Component
public class StopTimeLoader extends DbLoaderImpl<StopTime> {
    public StopTimeLoader(Repository<StopTime> repo, Parser<StopTime> parser) {
        super(repo, parser);
    }
}
