package com.bookapp.crud.service;


import com.bookapp.crud.model.Author;

import java.util.List;

public interface AuthorService {
    Author createAuthor(Author Author);
    Author getAuthor(long id);
    List<Author> getAllAuthors();
    void deleteAuthor(long id);
    Author updateAuthor(Author author);

}
