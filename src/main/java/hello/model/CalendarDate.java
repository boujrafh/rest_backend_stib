package hello.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class CalendarDate {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR_POOLED")
    Long id;

    public String serviceId;
    public Date date;
    public ExceptionType exceptionType;

    public CalendarDate(String serviceId, Date date, ExceptionType exceptionType) {
        this.serviceId = serviceId;
        this.date = date;
        this.exceptionType = exceptionType;
    }
}
