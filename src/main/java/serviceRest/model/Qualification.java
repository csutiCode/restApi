package serviceRest.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Qualification {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private long id;
    private String qualifier;
    private String opinion;
    private LocalDate createdOn = LocalDate.now();

    //@ManyToOne(fetch = FetchType.LAZY, optional = false)
    //@JoinColumn(name = "service_id")
    //private Service service;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public String toString() {
        return "Qualification{" +
                "qualifier='" + qualifier + '\'' +
                ", opinion='" + opinion + '\'' +
                '}';
    }
}
