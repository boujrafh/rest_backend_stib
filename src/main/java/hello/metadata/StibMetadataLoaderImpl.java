package hello.metadata;

import hello.io.InputStreamFactory;
import hello.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Component
public class StibMetadataLoaderImpl implements StibMetadataLoader {

    private final InputStreamFactory isf;
    private final DbLoader<Route> routesLoader;
    private final DbLoader<Agency> agenciesLoader;
    private final DbLoader<Calendar> calendarsLoader;
    private final DbLoader<Shape> shapesLoader;
    private final DbLoader<Stop> stopLoader;
    private final DbLoader<StopTime> stopTimeLoader;
    private final DbLoader<Translation> translationLoader;
    private final DbLoader<Trip> tripLoader;
    private final DbLoader<CalendarDate> calendarDateLoader;

    @Autowired
    public StibMetadataLoaderImpl(
            InputStreamFactory isf, DbLoader<Route> routesLoader, DbLoader<Agency> agenciesLoader,
            DbLoader<Calendar> calendarsLoader, DbLoader<Shape> shapesLoader, DbLoader<Stop> stopLoader,
            DbLoader<StopTime> stopTimeLoader, DbLoader<Translation> translationLoader, DbLoader<Trip> tripLoader, DbLoader<CalendarDate> calendarDateLoader) {
        this.isf = isf;
        this.routesLoader = routesLoader;
        this.agenciesLoader = agenciesLoader;
        this.calendarsLoader = calendarsLoader;
        this.shapesLoader = shapesLoader;
        this.stopLoader = stopLoader;
        this.stopTimeLoader = stopTimeLoader;
        this.translationLoader = translationLoader;
        this.tripLoader = tripLoader;
        this.calendarDateLoader = calendarDateLoader;
    }

    @Override
    public void loadMetadataToDb(String zipFilePath) {
        try {
            ZipInputStream zis = new ZipInputStream(isf.getInputStreamFromFile(zipFilePath));
            ZipEntry entry = zis.getNextEntry();
            while (entry != null) {
                if (!entry.isDirectory()) {
                    loadFile(entry.getName(), zis);
                }
                zis.closeEntry();
                entry = zis.getNextEntry();
            }
            zis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadFile(String fileName, ZipInputStream zis) {
        BufferedReader br = new BufferedReader(new InputStreamReader(zis, StandardCharsets.UTF_8));
        System.out.println("name of file: " + fileName);
        if (fileName.equals("agency.txt")) {
            agenciesLoader.loadToDb(br);
        }

        else if (fileName.equals("routes.txt")) {
            routesLoader.loadToDb(br);
        } else if (fileName.equals("calendar.txt")) {
            calendarsLoader.loadToDb(br);
        } else if (fileName.equals("calendar_dates.txt")) {
            calendarDateLoader.loadToDb(br);
        } else if (fileName.equals("shapes.txt")) {
            shapesLoader.loadToDb(br);
        } else if (fileName.equals("stops.txt")) {
            stopLoader.loadToDb(br);
        } else if (fileName.equals("stop_times.txt")) {
            stopTimeLoader.loadToDb(br);
        } else if (fileName.equals("translations.txt")) {
            translationLoader.loadToDb(br);

        }
        else if (fileName.equals("trips.txt")) {
            tripLoader.loadToDb(br);
        }
        System.out.println("end load file");
    }
}



