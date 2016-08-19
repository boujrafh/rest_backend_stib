package hello.metadata;

import hello.model.Route;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public class RoutesLoader extends DbLoaderImpl<Route> {

    public RoutesLoader(CrudRepository<Route, Long> repo, Parser<Route> parser) {
        super(repo, parser);
    }
}