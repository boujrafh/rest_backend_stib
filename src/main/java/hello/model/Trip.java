package hello.model;

import javax.persistence.*;

@Entity
public class Trip {
    @Id
    @GeneratedValue(generator= "ID_GENERATOR_POOLED")
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    public Route route;
    @OneToOne(fetch = FetchType.LAZY)
    public Calendar calendar;
    public String tripId;
    public String headSign;
    public Direction directionId;
    public String blockId;
    public String shapeId;

    public Trip(Route route, Calendar calendar, String tripId, String headSign,
                Direction directionId, String blockId, String shapeId) {
        this.route = route;
        this.calendar = calendar;
        this.tripId = tripId;
        this.headSign = headSign;
        this.directionId = directionId;
        this.blockId = blockId;
        this.shapeId = shapeId;
    }
}
