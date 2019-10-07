package com.bookapp.crud.service.datafetcher.author;

import com.bookapp.crud.dao.AuthorDao;
import com.bookapp.crud.model.Author;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class AuthorListDataFetcher implements DataFetcher<List<Author>> {

    @Autowired
    AuthorDao authorDao;

    @Override
    public List<Author> get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception {
        return authorDao.findAll();
    }
}
