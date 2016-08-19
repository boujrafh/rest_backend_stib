package hello.metadata;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.nio.file.Files;

@Component
public class StibMetadataDownloaderImpl implements StibMetadataDownloader {
    @Override
    public void downloadMetadata(String zipFilePath) {
        String uri = "https://opendata-api-acc.stib-mivb.be/Files/1.0/Gtfs";
        RestTemplate restTemplate = new RestTemplate();

        final RequestCallback rc = request -> request.getHeaders().add(
                HttpHeaders.AUTHORIZATION, "Bearer ");

        ResponseExtractor<Void> re = response -> {
            Files.copy(response.getBody(), new File(zipFilePath).toPath());
            return null;
        };

        restTemplate.execute(uri, HttpMethod.GET, rc, re);
    }
}
