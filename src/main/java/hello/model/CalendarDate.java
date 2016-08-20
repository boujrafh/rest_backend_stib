package hello.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CalendarDate {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR_POOLED")
    Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    public Calendar calendar;
    public Date date;
    public ExceptionType exceptionType;

    public CalendarDate(Calendar calendar, Date date, ExceptionType exceptionType) {
        this.calendar = calendar;
        this.date = date;
        this.exceptionType = exceptionType;
    }
}
