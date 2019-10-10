package com.bookapp.crud.model.graphql;

import com.bookapp.crud.model.Author;

public class CreateAuthorPayload {
    private long id;
    private String firstName;
    private String lastName;

    public CreateAuthorPayload(Author author) {
        this.id = author.getId();
        this.firstName = author.getFirstName();
        this.lastName = author.getLastName();
    }

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
}
