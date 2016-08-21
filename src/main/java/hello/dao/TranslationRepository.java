package hello.dao;

import hello.model.Translation;
import org.springframework.stereotype.Component;

import javax.ejb.Stateless;

@Component
@Stateless
public class TranslationRepository extends RepositoryImpl<Translation> {}
