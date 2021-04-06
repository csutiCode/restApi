package serviceRest.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }
}
