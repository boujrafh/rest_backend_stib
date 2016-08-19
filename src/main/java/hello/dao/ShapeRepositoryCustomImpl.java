package hello.dao;

import hello.model.Shape;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class ShapeRepositoryCustomImpl implements ShapeRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Transactional
    @Override
    public void bulkSave(List<Shape> shapes) {
        System.out.println("\nstart saving");
        long start = System.currentTimeMillis();
        for(Shape shape: shapes) {
            em.merge(shape);
        }
        long stop = System.currentTimeMillis();
        System.out.println("save time: " + (((double)stop - start)/1000));
    }
}
