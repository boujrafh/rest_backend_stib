package hello.metadata;

import hello.model.Agency;
import org.springframework.stereotype.Component;

@Component
public class AgencyParser implements Parser<Agency> {
    @Override
    public Agency parse(String line) {
        String[] splitLine = line.trim().split(",");
        return new Agency(
                splitLine[0],
                splitLine[1],
                splitLine[2],
                splitLine[3],
                splitLine[4]);
    }
}
