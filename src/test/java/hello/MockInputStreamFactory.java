package hello;

import hello.io.InputStreamFactory;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MockInputStreamFactory implements InputStreamFactory {

    private final byte[] data;

    public MockInputStreamFactory(byte[] data) {
        this.data = data;
    }

    @Override
    public InputStream getInputStreamFromFile(String fileName) {
        return new ByteArrayInputStream(data);
    }
}