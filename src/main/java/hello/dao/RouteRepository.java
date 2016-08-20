package hello.dao;

import hello.model.Route;

import java.util.List;

public interface RouteRepository {
    void save(List<Route> routes);
    Route getReference(String id);
}
