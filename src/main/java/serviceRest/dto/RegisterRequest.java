package serviceRest.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


public class RegisterRequest {

    @NotBlank(message = "Invalid E-Mail.")
    @Email(message = "Invalid E-Mail.")
    private String email;
    @NotBlank(message = "Invalid password")
    private String password;
    private String confirmedPassword;
    //private LocalDate createdOn = LocalDate.now();
    //private LocalDate dateOfBirth;

    public RegisterRequest() {

    }

    public RegisterRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }
}
