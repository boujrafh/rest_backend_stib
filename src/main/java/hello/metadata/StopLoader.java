package hello.metadata;

import hello.dao.Repository;
import hello.model.Stop;
import org.springframework.stereotype.Component;

@Component
public class StopLoader extends DbLoaderImpl<Stop> {
    public StopLoader(Repository<Stop> repo, Parser<Stop> parser) {
        super(repo, parser);
    }
}
