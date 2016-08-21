package hello.metadata;

import hello.dao.Repository;
import hello.model.Translation;
import org.springframework.stereotype.Component;

@Component
public class TranslationLoader extends DbLoaderImpl<Translation> {

    public TranslationLoader(Repository<Translation> repo, Parser<Translation> parser) {
        super(repo, parser);
    }
}
