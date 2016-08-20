package hello.metadata;

import hello.model.Stop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public class StopLoader extends DbLoaderImpl<Stop> {
    public StopLoader(CrudRepository<Stop, Long> repo, Parser<Stop> parser) {
        super(repo, parser);
    }
}
