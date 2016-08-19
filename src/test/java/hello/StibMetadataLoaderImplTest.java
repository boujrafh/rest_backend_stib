package hello;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class StibMetadataLoaderImplTest {

//    @Test
//    public void lalala() {
//        Map<String, String > texts = new HashMap<>();
//        texts.put("a.txt", "first document");
//        texts.put("b.txt", "second document");
//        byte[] data = createZippedData(texts);
//        InputStreamFactory isf = new MockInputStreamFactory(data);
//        StibMetadataLoader zipLoader =new StibMetadataLoaderImpl(isf, routeRepo);
//        zipLoader.loadMetadataToDb("abc");
//    }

    private byte[] createZippedData(Map<String, String> texts) {
        try  {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ZipOutputStream zos = new ZipOutputStream(bos);
            Set<Map.Entry<String, String>> entrySet = texts.entrySet();
            for(Map.Entry<String, String> text: entrySet) {
                zos.putNextEntry(new ZipEntry(text.getKey()));
                zos.write(text.getValue().getBytes(StandardCharsets.UTF_8));
                zos.closeEntry();
            }
            zos.close();
            return bos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
