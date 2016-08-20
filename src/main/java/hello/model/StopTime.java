package hello.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class StopTime {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "ID_GENERATOR_POOLED")
    Long id;
    public String tripId;
    public Date arrivalTime;
    public Date departureTime;
    public String stopId;
    public long stopSequence;
    public PickupType pickupType;
    public DropOffType dropOffType;

    StopTime() {}

    public StopTime(String tripId, Date arrivalTime, Date departureTime, String stopId,
                    long stopSequence, PickupType pickupType, DropOffType dropOffType) {
        this.tripId = tripId;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.stopId = stopId;
        this.stopSequence = stopSequence;
        this.pickupType = pickupType;
        this.dropOffType = dropOffType;
    }
}
