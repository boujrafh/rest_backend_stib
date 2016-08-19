package hello.metadata;

import java.io.BufferedReader;

public interface DbLoader<T> {
    void loadToDb(BufferedReader br);
}
