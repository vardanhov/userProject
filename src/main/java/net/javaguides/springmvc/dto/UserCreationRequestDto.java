package net.javaguides.springmvc.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class UserCreationRequestDto {

    @NotBlank(message = "{err.msg.email.required}")
    @Email(message = "{err.msg.email.invalid}")
    private String email;

    @NotBlank(message = "{err.msg.firstname.required}")
    private String firstName;

    @NotBlank(message = "{err.msg.lastname.required}")
    private String lastName;

    public UserCreationRequestDto() {
        super();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
