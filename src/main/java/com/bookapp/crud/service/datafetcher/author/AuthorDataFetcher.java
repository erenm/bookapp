package com.bookapp.crud.service.datafetcher.author;

import com.bookapp.crud.dao.AuthorDao;
import com.bookapp.crud.exception.AuthorNotFoundException;
import com.bookapp.crud.model.Author;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthorDataFetcher implements DataFetcher<Author> {

    @Autowired
    AuthorDao authorDao;

    @Override
    public Author get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception {
        Long id = dataFetchingEnvironment.getArgument("id");
        Optional<Author> authorOptional = authorDao.findById(id);
        Author author = authorOptional.orElseThrow(() -> new AuthorNotFoundException(id));
        return author;
    }
}
