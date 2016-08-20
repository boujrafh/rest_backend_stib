package hello.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "ID_GENERATOR_POOLED")
    Long id;
    public String routeId;
    public String serviceId;
    public String tripId;
    public String headSign;
    public Direction directionId;
    public String blockId;
    public String shapeId;

    public Trip(String routeId, String serviceId, String tripId, String headSign,
                Direction directionId, String blockId, String shapeId) {
        this.routeId = routeId;
        this.serviceId = serviceId;
        this.tripId = tripId;
        this.headSign = headSign;
        this.directionId = directionId;
        this.blockId = blockId;
        this.shapeId = shapeId;
    }
}
