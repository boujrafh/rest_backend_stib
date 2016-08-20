package hello.metadata;

import hello.dao.CalendarRepository;
import hello.model.CalendarDate;
import hello.model.ExceptionType;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class CalendarDateParser implements Parser<CalendarDate> {

    private final CalendarRepository repo;
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    public CalendarDateParser(CalendarRepository repo) {
        this.repo = repo;
    }

    @Override
    public CalendarDate parse(String line) {
        String[] splitLine = line.trim().split(",");
        return new CalendarDate(
                repo.getReference(splitLine[0]),
                parseToDate(splitLine[1]),
                parseToExceptionType(splitLine[2]));
    }

    private Date parseToDate(String date) {
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private ExceptionType parseToExceptionType(String exceptionType) {
        if(exceptionType.equals("1")) {
            return ExceptionType.ADDED;
        }
        if(exceptionType.equals("2")) {
            return ExceptionType.REMOVED;
        }
        throw new RuntimeException("cannot convert \"" + exceptionType + "\" to ExceptionType");
    }
}
