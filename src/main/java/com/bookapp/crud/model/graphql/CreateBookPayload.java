package com.bookapp.crud.model.graphql;

import com.bookapp.crud.model.Author;
import com.bookapp.crud.model.Book;

public class CreateBookPayload {

    private String title;
    private Author author;

    public CreateBookPayload(Book book) {
        this.title = book.getTitle();
        this.author = book.getAuthor();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
