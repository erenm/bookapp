package com.bookapp.crud.service.datafetcher.book;

import com.bookapp.crud.dao.BookDao;
import com.bookapp.crud.exception.BookNotFoundException;
import com.bookapp.crud.model.Book;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookDataFetcher implements DataFetcher<Book> {

    @Autowired
    BookDao bookDao;

    @Override
    public Book get(DataFetchingEnvironment env) throws Exception {
        Long id = env.getArgument("id");
        Optional<Book> bookOptional= bookDao.findById(id);
        Book book = bookOptional.orElseThrow(() -> new BookNotFoundException(id));
        return book;
    }
}
