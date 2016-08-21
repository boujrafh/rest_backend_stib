package hello.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Route {

    @Id
//    @GeneratedValue(generator = "ID_GENERATOR_POOLED")
//    public Long id;
    public String routeId;
    public String shortName;
    public String longName;
    @Column(name = "MY_DESC")
    public String desc;
    public String type;
    public String url;
    public String color;
    public String textColor;

    Route() {}

    public Route(
            String routeId,
            String shortName,
            String longName,
            String desc,
            String type,
            String url,
            String color,
            String textColor) {
        this.routeId = routeId;
        this.shortName = shortName;
        this.longName = longName;
        this.desc = desc;
        this.type = type;
        this.url = url;
        this.color = color;
        this.textColor = textColor;
    }
}
