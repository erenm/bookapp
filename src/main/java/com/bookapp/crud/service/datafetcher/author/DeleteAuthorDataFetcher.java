package com.bookapp.crud.service.datafetcher.author;

import com.bookapp.crud.dao.AuthorDao;
import com.bookapp.crud.exception.AuthorNotFoundException;
import com.bookapp.crud.model.Author;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteAuthorDataFetcher implements DataFetcher<Boolean> {
    @Autowired
    AuthorDao authorDao;

    @Override
    public Boolean get(DataFetchingEnvironment env) throws Exception {
        Long id = Long.valueOf(env.getArgument("id"));
        authorDao.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));
        authorDao.deleteById(id);
        return true;
    }
}
