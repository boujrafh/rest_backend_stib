package hello.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stop {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "ID_GENERATOR_POOLED")
    Long id;
    public String gtfsId;
    public String code;
    public String name;
    public String desc;
    public double latitude;
    public double longitude;
    public String zoneId;
    public String url;
    public LocationType locationType;

    public Stop(String gtfsId, String code, String name, String desc, double latitude,
                double longitude, String zoneId, String url, LocationType locationType) {
        this.gtfsId = gtfsId;
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
