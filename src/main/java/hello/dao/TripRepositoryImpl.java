package hello.dao;

import hello.model.Trip;
import org.springframework.stereotype.Component;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Component
@Stateless
public class TripRepositoryImpl implements TripRepository {
    @PersistenceContext
    EntityManager em;

    @Transactional
    @Override
    public void save(List<Trip> trips) {
        for(int i = 0; i < trips.size(); i = i + 20) {
            for(int j = 0; j < 20 && (i+j) < trips.size(); j++) {
                em.persist(trips.get(i + j));
                em.flush();
                em.clear();
            }
        }
    }

    @Transactional
    @Override
    public Trip getReference(String id) {
        return em.getReference(Trip.class, id);
    }
}
