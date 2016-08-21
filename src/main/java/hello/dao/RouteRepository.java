package hello.dao;

import hello.model.Route;
import org.springframework.stereotype.Component;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Stateless
public class RouteRepositoryImpl implements RouteRepository {
    @PersistenceContext
    EntityManager em;

    @Transactional
    @Override
    public void save(List<Route> routes) {
        for(Route route: routes) {
            em.persist(route);
        }
    }

    @Transactional
    @Override
    public Route getReference(String id) {
        return em.getReference(Route.class, id);
    }
}
