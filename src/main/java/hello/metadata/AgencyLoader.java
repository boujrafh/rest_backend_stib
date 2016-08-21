package hello.metadata;

import hello.dao.Repository;
import hello.model.Agency;
import org.springframework.stereotype.Component;

@Component
public class AgencyLoader extends DbLoaderImpl<Agency> {
    public AgencyLoader(Repository<Agency> repo, Parser<Agency> parser) {
        super(repo, parser);
    }
}
