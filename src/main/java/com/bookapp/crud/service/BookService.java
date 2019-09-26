package com.bookapp.crud.service;


import com.bookapp.crud.model.Book;

public interface BookService {
    void addBook(Book book);
    void getBook(long id);
    void updateBook(Book book);
    void deleteBook(long id);
}
