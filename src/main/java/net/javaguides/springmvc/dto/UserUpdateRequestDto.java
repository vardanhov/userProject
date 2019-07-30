package net.javaguides.springmvc.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class UserUpdateRequestDto {

    // TODO: 5/10/2019 Change message
    @NotBlank(message = "{err.msg.firstname.required}")
    private String id;

    @NotBlank(message = "{err.msg.email.required}")
    @Email(message = "{err.msg.email.invalid}")
    private String email;

    @NotBlank(message = "{err.msg.firstname.required}")
    private String firstName;

    @NotBlank(message = "{err.msg.lastname.required}")
    private String lastName;

    public UserUpdateRequestDto() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
