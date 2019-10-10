package com.bookapp.crud.service.datafetcher.book;

import com.bookapp.crud.dao.BookDao;
import com.bookapp.crud.exception.BookNotFoundException;
import com.bookapp.crud.model.Book;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteBookDataFetcher implements DataFetcher<Boolean> {

    @Autowired
    BookDao bookDao;

    @Override
    public Boolean get(DataFetchingEnvironment env) throws Exception {
        Long id = Long.valueOf(env.getArgument("id"));
        bookDao.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        bookDao.deleteById(id);
        return true;
    }
}
