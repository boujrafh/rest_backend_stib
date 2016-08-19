package hello.controller;

import hello.metadata.StibMetadataDownloader;
import hello.metadata.StibMetadataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

@RestController
public class StibMetadataController {

    private final StibMetadataDownloader downloader;
    private final StibMetadataLoader loader;

    @Autowired
    public StibMetadataController(StibMetadataDownloader downloader, StibMetadataLoader loader) {

        this.downloader = downloader;
        this.loader = loader;
    }

    @RequestMapping(value = "/dlmetadata", method = RequestMethod.PUT)
    public void downloadMetadata() {

        try {
            downloader.downloadMetadata("stib_metadata.zip");
        } catch (RestClientException e) {
            throw new DownloadFailedException();
        }
    }

    @RequestMapping(value = "/loadmetadata", method = RequestMethod.PUT)
    public void loadMetadata() {
        loader.loadMetadataToDb("stib_metadata.zip");
    }
}
