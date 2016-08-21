package hello.metadata;

import hello.dao.Repository;
import hello.model.Trip;
import org.springframework.stereotype.Component;

@Component
public class TripLoader extends DbLoaderImpl<Trip> {
    public TripLoader(Repository<Trip> repo, Parser<Trip> parser) {
        super(repo, parser);
    }
}
