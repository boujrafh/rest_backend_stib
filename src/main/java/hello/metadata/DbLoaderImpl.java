package hello.metadata;

import hello.dao.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DbLoaderImpl<T> implements DbLoader<T> {
    private final Repository<T> repo;
    private final Parser<T> parser;

    @Autowired
    public DbLoaderImpl(Repository<T> repo, Parser<T> parser) {
        this.repo = repo;
        this.parser = parser;
    }

    @Override
    public void loadToDb(BufferedReader br) {
        try {
            br.readLine(); // skip metadata
            List<T> temp = new ArrayList<>(Constants.BATCH_SIZE);
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
            long stop = System.currentTimeMillis();
            System.out.println("time to process: " + (((double)stop - start) / 1000));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void timedSave(List<T> tList) {
        long start = System.currentTimeMillis();
        repo.save(tList);
        long stop = System.currentTimeMillis();
        System.out.println("time to save: " + (((double)stop - start) / 1000));
    }
}
