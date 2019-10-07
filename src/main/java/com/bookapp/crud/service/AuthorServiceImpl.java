package com.bookapp.crud.service;

import com.bookapp.crud.dao.AuthorDao;
import com.bookapp.crud.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDao authorDao;

    public AuthorServiceImpl(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public Author createAuthor(Author author) {
        return authorDao.save(author);
    }

    @Override
    public Optional<Author> getAuthor(long id) {
        return authorDao.findById(id);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorDao.findAll();
    }

    @Override
    public void deleteAuthor(long id) {
        authorDao.deleteById(id);
    }

    @Override
    public Author updateAuthor(Author author) {
        return authorDao.save(author);
    }
}
