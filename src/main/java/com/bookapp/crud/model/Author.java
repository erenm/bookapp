package com.bookapp.crud.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Author")
public class Author{
    @Id
    @GeneratedValue
    private long id;

    private String firstName;
    private String lastName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="author")
    private List<Book> books;

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

    public List<Book> getBookList() {
        return books;
    }

    public void setBookList(List<Book> books) {
        this.books = books;
    }
}