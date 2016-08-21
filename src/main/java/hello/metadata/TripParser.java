package hello.metadata;

import hello.dao.Repository;
import hello.model.Calendar;
import hello.model.Direction;
import hello.model.Route;
import hello.model.Trip;
import org.springframework.stereotype.Component;

@Component
public class TripParser implements Parser<Trip> {

    private final Repository<Route> routeRepo;
    private final Repository<Calendar> calendarRepo;

    public TripParser(Repository<Route> routeRepo, Repository<Calendar> calendarRepo) {
        this.routeRepo = routeRepo;
        this.calendarRepo = calendarRepo;
    }

    @Override
    public Trip parse(String line) {
        String[] splitLine = line.trim().split(",");
        return new Trip(
                routeRepo.getReference(Route.class, splitLine[0]),
                calendarRepo.getReference(Calendar.class, splitLine[1]),
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
