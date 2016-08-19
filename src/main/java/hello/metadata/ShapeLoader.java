package hello.metadata;

import hello.model.Shape;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public class ShapeLoader extends DbLoaderImpl<Shape> {

    public ShapeLoader(CrudRepository<Shape, Long> repo, Parser<Shape> parser) {
        super(repo, parser);
    }
}