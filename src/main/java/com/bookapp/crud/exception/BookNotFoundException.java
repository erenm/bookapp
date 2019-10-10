package com.bookapp.crud.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class BookNotFoundException extends RuntimeException implements GraphQLError{
    private Long bookId;

    public BookNotFoundException(Long authorId) {
        this.bookId = bookId;
    }

    @Override
    public String getMessage() {
        return "Book with ID " + bookId + " could not be found";
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
        return Collections.singletonMap("bookId", bookId);
    }

    @Override
    @JsonIgnore
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }
}
