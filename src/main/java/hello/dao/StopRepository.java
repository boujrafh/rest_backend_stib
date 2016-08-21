package hello.dao;

import hello.model.Stop;
import org.springframework.stereotype.Component;

import javax.ejb.Stateless;

@Component
@Stateless
public class StopRepository extends RepositoryImpl<Stop> {}
