package hello.metadata;

import hello.dao.Repository;
import hello.model.Route;
import org.springframework.stereotype.Component;

@Component
public class RouteLoader extends DbLoaderImpl<Route> {
    public RouteLoader(Repository<Route> repo, Parser<Route> parser) {
        super(repo, parser);
    }
}
