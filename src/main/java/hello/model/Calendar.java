package hello.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Calendar {

//    @Id
//    @GeneratedValue(generator = "ID_GENERATOR_POOLED")
//    public Long id;
    @Id
    public String serviceId;
    @Column
    public boolean monday;
    @Column
    public boolean tuesday;
    @Column
    public boolean wednesday;
    @Column
    public boolean thursday;
    @Column
    public boolean friday;
    @Column
    public boolean saturday;
    @Column
    public boolean sunday;
    @Column
    public Date startDate;
    @Column
    public Date endDate;

    Calendar() {}

    public Calendar(
            String serviceId,
            boolean monday,
            boolean tuesday,
            boolean wednesday,
            boolean thursday,
            boolean friday,
            boolean saturday,
            boolean sunday,
            Date startDate,
            Date endDate) {
        this.serviceId = serviceId;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
