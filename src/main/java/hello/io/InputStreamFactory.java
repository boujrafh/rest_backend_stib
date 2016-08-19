package hello.io;

import java.io.InputStream;

public interface InputStreamFactory {
    InputStream getInputStreamFromFile(String fileName);
}
