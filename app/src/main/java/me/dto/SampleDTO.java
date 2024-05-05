package me.dto;

import java.io.Serializable;

public class SampleDTO implements Serializable {
    private String firstName;
    private String lastName;
    private String message;

    public SampleDTO(final String firstName, final String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setMessage("Hello");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }
}