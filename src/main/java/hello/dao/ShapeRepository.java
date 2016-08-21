package hello.dao;

import hello.model.Shape;
import org.springframework.stereotype.Component;

import javax.ejb.Stateless;

@Component
@Stateless
public class ShapeRepository extends RepositoryImpl<Shape> {}
