package com.bookapp.crud.model.graphql;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class CreateAuthorInput {
    private String firstName;
    private String lastName;

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

    public static CreateAuthorInput fromMap(Map<String, Object> map){
        final ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(map, CreateAuthorInput.class);
    }
}
