package hello.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Translation {
    @Id
    @GeneratedValue(generator= "ID_GENERATOR_POOLED")
    Long id;
    public String transId;
    public String translation;
    public String lang;

    Translation() {}

    public Translation(String transId, String translation, String lang) {
        this.transId = transId;
        this.translation = translation;
        this.lang = lang;
    }
}
