package net.javaguides.springmvc.service.user;

import org.springframework.util.Assert;

public class UserUpdateRequest {

    private final String id;

    private final String email;

    private final String firstName;

    private final String lastName;

    public UserUpdateRequest(final String id, final String email, final String firstName, final String lastName) {
        Assert.hasText(id, "id cannot be null or empty.");
        Assert.hasText(email, "email cannot be null or empty.");
        Assert.hasText(firstName, "firstName cannot be null or empty.");
        Assert.hasText(lastName, "lastName cannot be null or empty.");

        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
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