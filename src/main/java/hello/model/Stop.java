package hello.model;

import javax.persistence.*;

@Entity
public class Stop {

    @Id
    @GeneratedValue(generator= "ID_GENERATOR_POOLED")
    Long id;
    public String stopId;
    public String code;
    public String name;
    @Column(name = "MY_DESC")
    public String desc;
    public double latitude;
    public double longitude;
    public String zoneId;
    public String url;
    public LocationType locationType;

    public Stop(String stopId, String code, String name, String desc, double latitude,
                double longitude, String zoneId, String url, LocationType locationType) {
        this.stopId = stopId;
        this.code = code;
        this.name = name;
        this.desc = desc;
        this.latitude = latitude;
        this.longitude = longitude;
        this.zoneId = zoneId;
        this.url = url;
        this.locationType = locationType;
    }
}
