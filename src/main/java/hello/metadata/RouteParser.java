package hello.metadata;

import hello.model.Route;
import org.springframework.stereotype.Component;

@Component
public class RouteParser implements Parser<Route> {
    @Override
    public Route parse(String line) {
        String[] splitLine = line.trim().split(",");
        return new Route(
                splitLine[0],
                splitLine[1],
                splitLine[2],
                splitLine[3],
                splitLine[4],
                splitLine[5],
                splitLine[6],
                splitLine[7]);
    }
}
