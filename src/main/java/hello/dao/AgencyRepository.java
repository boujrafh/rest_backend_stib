package hello.dao;

import hello.model.Agency;
import org.springframework.stereotype.Component;

import javax.ejb.Stateless;

@Component
@Stateless
public class AgencyRepository extends RepositoryImpl<Agency> {}
