package hello.metadata;

import hello.dao.Repository;
import hello.model.Shape;
import org.springframework.stereotype.Component;

@Component
public class ShapeLoader extends DbLoaderImpl<Shape> {

    public ShapeLoader(Repository<Shape> repo, Parser<Shape> parser) {
        super(repo, parser);
    }
}