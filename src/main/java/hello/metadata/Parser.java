package hello.metadata;

public interface Parser<T> {

    T parse(String line);

}
