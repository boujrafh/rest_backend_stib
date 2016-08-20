package hello.metadata;

import hello.model.Translation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public class TranslationLoader extends DbLoaderImpl<Translation> {

    public TranslationLoader(CrudRepository<Translation, Long> repo, Parser<Translation> parser) {
        super(repo, parser);
    }
}
