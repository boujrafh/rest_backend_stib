package hello.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Route {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR_POOLED")
    public Long id;
    public String gtfsId;
    public String shortName;
    public String longName;
    public String desc;
    public String type;
    public String url;
    public String color;
    public String textColor;

    Route() {}

    public Route(
            String gtfsId,
            String shortName,
            String longName,
            String desc,
            String type,
            String url,
            String color,
            String textColor) {
        this.gtfsId = gtfsId;
        this.shortName = shortName;
        this.longName = longName;
        this.desc = desc;
        this.type = type;
        this.url = url;
        this.color = color;
        this.textColor = textColor;
    }
}