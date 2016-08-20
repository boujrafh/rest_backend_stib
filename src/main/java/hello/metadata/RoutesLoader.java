package hello.metadata;

import hello.dao.CalendarRepository;
import hello.dao.RouteRepository;
import hello.model.Calendar;
import hello.model.Route;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class RoutesLoader implements DbLoader<Route> {

    private final RouteRepository repo;
    private final Parser<Route> parser;

    public RoutesLoader(RouteRepository repo, Parser<Route> parser) {
        this.repo = repo;
        this.parser = parser;
    }

    @Override
    public void loadToDb(BufferedReader br) {
        try {
            br.readLine(); // skip metadata
            List<Route> temp = new ArrayList<>(Constants.BATCH_SIZE);
            int count = 0;
            String line = br.readLine();
            while(line != null) {
                temp.add(parser.parse(line));
                line = br.readLine();
                if(temp.size() == Constants.BATCH_SIZE) {
                    repo.save(temp);
                    temp.clear();
                }
            }
            repo.save(temp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}