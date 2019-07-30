package net.javaguides.springmvc.service.user;

import org.springframework.util.Assert;

public class UserCreationRequest {

    private final String email;

    private final String firstName;

    private final String lastName;

    public UserCreationRequest(final String email, final String firstName, final String lastName) {
        Assert.hasText(email, "email cannot be null or empty.");
        Assert.hasText(firstName, "firstName cannot be null or empty.");
        Assert.hasText(lastName, "lastName cannot be null or empty.");

        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}