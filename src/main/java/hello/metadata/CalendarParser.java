package hello.metadata;

import hello.model.Calendar;
import org.springframework.stereotype.Component;

@Component
public class CalendarParser implements Parser<Calendar> {
    @Override
    public Calendar parse(String line) {
        String[] splitLine = line.trim().split(",");
        return new Calendar(
                splitLine[0],
                parseIntToBool(splitLine[1]),
                parseIntToBool(splitLine[2]),
                parseIntToBool(splitLine[3]),
                parseIntToBool(splitLine[4]),
                parseIntToBool(splitLine[5]),
                parseIntToBool(splitLine[6]),
                parseIntToBool(splitLine[7]),
                splitLine[8],
                splitLine[9]);
    }

    boolean parseIntToBool(String integer) {
        if(integer.equals("0")) {
            return false;
        }
        if(integer.equals("1")) {
            return true;
        }
        throw new RuntimeException("cannot convert \"" + integer + "\" to boolean");
    }
}
