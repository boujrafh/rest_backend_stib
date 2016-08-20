package hello.metadata;

import hello.model.LocationType;
import hello.model.Stop;
import org.springframework.stereotype.Component;

@Component
public class StopParser implements Parser<Stop> {
    @Override
    public Stop parse(String line) {
        String[] splitLine = line.trim().split(",");
        return new Stop(
                splitLine[0],
                splitLine[1],
                splitLine[2],
                splitLine[3],
                Double.parseDouble(splitLine[4]),
                Double.parseDouble(splitLine[5]),
                splitLine[6],
                splitLine[7],
                parseLocationType(splitLine[8]));
    }

    private LocationType parseLocationType(String locationType) {
        if(locationType.equals("0")) {
            return LocationType.STOP;
        }
        if(locationType.equals("1")) {
            return LocationType.STATION;
        }
        throw new RuntimeException("cannot convert \"" + locationType + "\" to LocationType");
    }
}
