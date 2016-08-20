package hello.metadata;

import hello.model.StopTime;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public class StopTimeLoader extends DbLoaderImpl<StopTime> {
    public StopTimeLoader(CrudRepository<StopTime, Long> repo, Parser<StopTime> parser) {
        super(repo, parser);
    }
}
