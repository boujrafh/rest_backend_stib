package hello.metadata;

import hello.model.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public class TripLoader extends DbLoaderImpl<Trip> {
    public TripLoader(CrudRepository<Trip, Long> repo, Parser<Trip> parser) {
        super(repo, parser);
    }
}
