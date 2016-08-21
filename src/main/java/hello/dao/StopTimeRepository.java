package hello.dao;

import hello.model.StopTime;
import org.springframework.stereotype.Component;

import javax.ejb.Stateless;

@Component
@Stateless
public class StopTimeRepository extends RepositoryImpl<StopTime> {}
