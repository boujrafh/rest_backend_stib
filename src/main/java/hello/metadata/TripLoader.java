package hello.metadata;

import hello.dao.CalendarRepository;
import hello.dao.TripRepository;
import hello.model.Calendar;
import hello.model.Trip;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TripLoader implements DbLoader<Trip> {
    private final TripRepository repo;
    private final Parser<Trip> parser;

    public TripLoader(TripRepository repo, Parser<Trip> parser) {
        this.repo = repo;
        this.parser = parser;
    }

    @Override
    public void loadToDb(BufferedReader br) {
        try {
            br.readLine(); // skip metadata
            List<Trip> temp = new ArrayList<>(Constants.BATCH_SIZE);
            int count = 0;
            long start = System.currentTimeMillis();
            String line = br.readLine();
            while(line != null) {
                temp.add(parser.parse(line));
                line = br.readLine();
                if(temp.size() == Constants.BATCH_SIZE) {
                    timedSave(temp);
                    temp = new ArrayList<>(Constants.BATCH_SIZE);
                    long stop = System.currentTimeMillis();
                    System.out.println("time to process: " + (((double)stop - start) / 1000));
                    start = System.currentTimeMillis();
                }
            }
            timedSave(temp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void timedSave(List<Trip> trips) {
        long start = System.currentTimeMillis();
        repo.save(trips);
        long stop = System.currentTimeMillis();
        System.out.println("time to save: " + (((double)stop - start) / 1000));
    }
}
