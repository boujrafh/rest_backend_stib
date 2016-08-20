package hello.dao;

import hello.model.Translation;
import org.springframework.data.repository.CrudRepository;

public interface TranslationRepository extends CrudRepository<Translation, Long> {
}
