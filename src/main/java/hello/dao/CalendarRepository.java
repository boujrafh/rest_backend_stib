package hello.dao;

import hello.model.Calendar;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class CalendarRepositoryImpl  {

    @PersistenceContext
    EntityManager em;

    @Transactional
    @Override
    public void save(List<Calendar> calendars) {
        for(Calendar calendar: calendars) {
            em.persist(calendar);
        }
    }

    @Transactional
    @Override
    public Calendar getReference(String id) {
        return em.getReference(Calendar.class, id);
    }
}
