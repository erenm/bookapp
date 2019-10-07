package com.bookapp.crud.service;


import com.bookapp.crud.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Author createAuthor(Author Author);
    Optional<Author>getAuthor(long id);
    List<Author> getAllAuthors();
    void deleteAuthor(long id);
    Author updateAuthor(Author author);

}
