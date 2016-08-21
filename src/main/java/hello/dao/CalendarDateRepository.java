package hello.dao;

import hello.model.CalendarDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class CalendarDateRepositoryImpl implements CalendarDateRepository{
    @PersistenceContext
    EntityManager em;

    public void save(List<CalendarDate> CalendarDates) {
        for(int i = 0; i < CalendarDates.size(); i = i + 20) {
            for(int j = 0; j < 20 && (i+j) < CalendarDates.size(); j++) {
                em.persist(CalendarDates.get(i + j));
                em.flush();
                em.clear();
            }
        }
    }

    @Transactional
    @Override
    public CalendarDate getReference(String id) {
        return em.getReference(CalendarDate.class, id);
    }
}