package hello.metadata;

import hello.model.DropOffType;
import hello.model.PickupType;
import hello.model.Route;
import hello.model.StopTime;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class StopTimeParser implements Parser<StopTime> {

    private final SimpleDateFormat sdf = new SimpleDateFormat("H:m:s");

    @Override
    public StopTime parse(String line) {
        String[] splitLine = line.trim().split(",");
        return new StopTime(
                splitLine[0],
                parseToDate(splitLine[1]),
                parseToDate(splitLine[2]),
                splitLine[3],
                Long.parseLong(splitLine[4]),
                parseToPickupType(splitLine[5]),
                parseToDropOffType(splitLine[6]));
    }

    private Date parseToDate(String date) {
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private PickupType parseToPickupType(String pickupType) {
        if(pickupType.equals("0"))
            return PickupType.REGULARY_SCHEDULED;
        if(pickupType.equals("1"))
            return PickupType.NONE;
        if(pickupType.equals("2"))
            return PickupType.MUST_PHONE_AGENCY;
        if(pickupType.equals("3"))
            return PickupType.MUST_COORDINATE_WITH_DRIVER;
        throw new RuntimeException("Could not parse " + pickupType + " to PickupType");
    }

    private DropOffType parseToDropOffType(String dropOffType) {
        if(dropOffType.equals("0"))
            return DropOffType.REGULARY_SCHEDULED;
        if(dropOffType.equals("1"))
            return DropOffType.NONE;
        if(dropOffType.equals("2"))
            return DropOffType.MUST_PHONE_AGENCY;
        if(dropOffType.equals("3"))
            return DropOffType.MUST_COORDINATE_WITH_DRIVER;
        throw new RuntimeException("Could not parse " + dropOffType + " to DropOffType");
    }
}
