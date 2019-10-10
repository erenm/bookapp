package com.bookapp.crud.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class AuthorNotFoundException extends RuntimeException implements GraphQLError{
    private Long authorId;

    public AuthorNotFoundException(Long authorId) {
        this.authorId = authorId;
    }

    @Override
    public String getMessage() {
        return "Author with ID " + authorId + " could not be found";
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.ValidationError;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return Collections.singletonMap("authorId", authorId);
    }

    @Override
    @JsonIgnore
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }
}
