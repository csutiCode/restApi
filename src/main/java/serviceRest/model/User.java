package serviceRest.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String password;
    private LocalDate createdOn;
    private LocalDate dateOfBirth;

    @OneToOne
    private ServiceAccount serviceAccount;

    public ServiceAccount getServiceAccount() {
        return serviceAccount;
    }

    public void setServiceAccount(ServiceAccount serviceAccount) {
        this.serviceAccount = serviceAccount;
    }

    public User(String username, String password) {
    }

    public User() {};

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }



}
