package hello.dao;

import hello.model.Route;
import org.springframework.stereotype.Component;

import javax.ejb.Stateless;

@Component
@Stateless
public class RouteRepository extends RepositoryImpl<Route> {}