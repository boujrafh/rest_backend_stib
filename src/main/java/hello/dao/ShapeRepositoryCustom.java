package hello.dao;

import hello.model.Shape;

import java.util.List;

public interface ShapeRepositoryCustom {
    void bulkSave(List<Shape> shapes);
}
