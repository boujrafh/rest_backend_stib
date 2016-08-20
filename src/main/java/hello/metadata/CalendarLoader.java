package hello.metadata;

import hello.dao.CalendarRepository;
import hello.model.Calendar;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CalendarLoader implements DbLoader<Calendar> {

    private final CalendarRepository repo;
    private final Parser<Calendar> parser;

    public CalendarLoader(CalendarRepository repo, Parser<Calendar> parser) {
        this.repo = repo;
        this.parser = parser;
    }

    @Override
    public void loadToDb(BufferedReader br) {
        try {
            br.readLine(); // skip metadata
            List<Calendar> temp = new ArrayList<>(Constants.BATCH_SIZE);
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
