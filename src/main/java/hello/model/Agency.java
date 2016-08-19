package hello.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Agency {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR_POOLED")
    public Long id;
    public String name;
    String url;
    String timezone;
    String lang;
    String phone;

    Agency() {}

    public Agency(String name, String url, String timezone, String lang, String phone) {
        this.name = name;
        this.url = url;
        this.timezone = timezone;
        this.lang = lang;
        this.phone = phone;
    }
}
