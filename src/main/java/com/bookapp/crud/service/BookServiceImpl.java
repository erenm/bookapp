package com.bookapp.crud.service;

import com.bookapp.crud.dao.BookDao;
import com.bookapp.crud.model.Author;
import com.bookapp.crud.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookDao bookDao;

    @Override
    public Book addBook(Book book) {
        return bookDao.save(book);
    }

    @Override
    public Optional<Book> getBook(long id) {
        return bookDao.findById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }

    @Override
    public List<Book> getBooksByAuthor(Author author) {
        return bookDao.findBooksByAuthor(author);
    }

    @Override
    public Book updateBook(Book book) {
        return null;
    }

    @Override
    public void deleteBook(long id) {

    }

}
