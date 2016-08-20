package hello.dao;

import hello.model.Trip;
import org.springframework.stereotype.Component;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Stateless
public class TripRepositoryImpl implements TripRepository {
    @PersistenceContext
    EntityManager em;

    @Transactional
    @Override
    public void save(List<Trip> trips) {
        for(Trip trip: trips) {
            em.persist(trip);
        }
    }

    @Transactional
    @Override
    public Trip getReference(String id) {
        return em.getReference(Trip.class, id);
    }
}
