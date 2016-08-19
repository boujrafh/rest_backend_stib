package hello.metadata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DbLoaderImpl<T> implements DbLoader<T> {
    private final CrudRepository<T, Long> repo;
    private final Parser<T> parser;

    @Autowired
    public DbLoaderImpl(CrudRepository<T, Long> repo, Parser<T> parser) {
        this.repo = repo;
        this.parser = parser;
    }

    @Override
    public void loadToDb(BufferedReader br) {
        try {
            br.readLine(); // skip metadata
            List<T> temp = new ArrayList<>(Constants.BATCH_SIZE);
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
