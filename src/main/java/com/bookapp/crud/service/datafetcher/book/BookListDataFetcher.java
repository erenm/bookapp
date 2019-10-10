package com.bookapp.crud.service.datafetcher.book;

import com.bookapp.crud.dao.BookDao;
import com.bookapp.crud.model.Book;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookListDataFetcher implements DataFetcher<List<Book>> {

    @Autowired
    BookDao bookDao;

    @Override
    public List<Book> get(DataFetchingEnvironment env) throws Exception {
        return bookDao.findAll();
    }
}
