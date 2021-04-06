package serviceRest.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;
    private String name;

    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    //private List<Service> services = new ArrayList<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return name;
    }
}
