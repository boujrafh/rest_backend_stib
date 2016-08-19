package hello.dao;

import hello.model.Shape;
import org.springframework.data.repository.CrudRepository;

public interface ShapeRepository extends CrudRepository<Shape, Long> {
}
