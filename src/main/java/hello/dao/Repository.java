package hello.dao;

import javax.ejb.Stateless;
import java.util.List;
@Stateless
public interface Repository<T> {
    void save(List<T> tList);
    T getReference(Class<T> clazz,String id);
}

