package com.bookapp.crud.service.datafetcher.author;

import com.bookapp.crud.dao.AuthorDao;
import com.bookapp.crud.model.Author;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorDataFetcher implements DataFetcher<Author> {

    @Autowired
    AuthorDao authorDao;

    @Override
    public Author get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception {
        Long id = dataFetchingEnvironment.getArgument("id");
        return authorDao.getOne(id);
    }
}
