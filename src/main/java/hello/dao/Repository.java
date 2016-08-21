package hello.dao;

import java.util.List;

public interface Repositories <T> {
    void save(List<T> tList);
    T getReference(String id);
}

