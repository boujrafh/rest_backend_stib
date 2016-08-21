package hello.dao;

import hello.model.Trip;
import org.springframework.stereotype.Component;

import javax.ejb.Stateless;

@Component
@Stateless
public class TripRepository extends RepositoryImpl<Trip> {}
