package com.bookapp.crud.service;


import com.bookapp.crud.model.Author;
import com.bookapp.crud.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book addBook(Book book);
    Optional<Book> getBook(long id);
    List<Book> getAllBooks();
    List<Book> getBooksByAuthor(Author author);
    Book updateBook(Book book);
    void deleteBook(long id);
}
