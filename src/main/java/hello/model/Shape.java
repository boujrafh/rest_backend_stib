package hello.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Shape {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "ID_GENERATOR_POOLED")
    public Long id;
    public String shapeId;
    public String ptLat;
    public String ptLon;
    public String ptSequence;

    Shape(){}

    public Shape(String shapeId, String ptLat, String ptLon, String ptSequence) {
        this.shapeId = shapeId;
        this.ptLat = ptLat;
        this.ptLon = ptLon;
        this.ptSequence = ptSequence;
    }
}