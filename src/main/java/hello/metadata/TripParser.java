package hello.metadata;

import hello.dao.CalendarRepository;
import hello.dao.RouteRepository;
import hello.model.Direction;
import hello.model.Trip;
import org.springframework.stereotype.Component;

@Component
public class TripParser implements Parser<Trip> {

    private final RouteRepository routeRepo;
    private final CalendarRepository calendarRepo;

    public TripParser(RouteRepository routeRepo, CalendarRepository calendarRepo) {
        this.routeRepo = routeRepo;
        this.calendarRepo = calendarRepo;
    }

    @Override
    public Trip parse(String line) {
        String[] splitLine = line.trim().split(",");
        return new Trip(
                routeRepo.getReference(splitLine[0]),
                calendarRepo.getReference(splitLine[1]),
                splitLine[2],
                splitLine[3],
                parseTodirection(splitLine[4]),
                splitLine[5],
                splitLine[6]);
    }

    private Direction parseTodirection(String direction) {
        if(direction.equals("0"))
            return Direction.OUTBOND;
        if(direction.equals("1"))
            return Direction.INBOND;
        throw new RuntimeException("could not parse " + direction + " to Direction");
    }
}
