package hello.metadata;

import hello.model.Agency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public class AgencyLoader extends DbLoaderImpl<Agency> {

    public AgencyLoader(CrudRepository<Agency, Long> repo, Parser<Agency> parser) {
        super(repo, parser);
    }
}