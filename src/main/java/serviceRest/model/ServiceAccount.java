package serviceRest.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ServiceAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;
    private String firstName;
    private String lastName;
    private String providedService;
    private String email;
    private String telephone;
    @Lob
    private String about;
    private LocalDate lastUpdated = LocalDate.now();
    @Lob
    private String pictureUrl;

    @OneToMany
    @JoinColumn(name = "service_id")
    private Set<Qualification> qualifications = new HashSet<>();

    //has to be UNIDIRECTIONAL, no need JoinColumn
    @ManyToOne
    private City city;

    //has to be UNIDIRECTIONAL, no need JoinColumn
    @ManyToOne
    private Category category;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProvidedService() {
        return providedService;
    }

    public void setProvidedService(String providedService) {
        this.providedService = providedService;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Set<Qualification> getQualifications() {
        return qualifications;
    }

    public void setQualifications(Set<Qualification> qualifications) {
        this.qualifications = qualifications;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Service{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
