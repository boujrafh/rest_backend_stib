package hello.dao;

import hello.model.Trip;

import java.util.Collection;
import java.util.List;

public interface TripRepository {
    void save(List<Trip> routes);
    Trip getReference(String id);
}
