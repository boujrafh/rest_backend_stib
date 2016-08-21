package hello.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


public class RepositoryImpl<T> implements Repository<T> {

    @PersistenceContext
    EntityManager em;

    @Transactional
    @Override
    public void save(List<T> tList) {
        for(int i = 0; i < tList.size(); i = i + 20) {
            for(int j = 0; j < 20 && (i+j) < tList.size(); j++) {
                em.persist(tList.get(i + j));
                em.flush();
                em.clear();
            }
        }
    }


    @Transactional
    @Override
    public T getReference(Class<T> clazz , String id) {
        return em.getReference(clazz, id);
    }
}