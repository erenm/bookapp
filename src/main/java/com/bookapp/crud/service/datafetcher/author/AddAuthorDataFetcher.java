package com.bookapp.crud.service.datafetcher.author;

import com.bookapp.crud.dao.AuthorDao;
import com.bookapp.crud.model.Author;
import com.bookapp.crud.model.graphql.CreateAuthorInput;
import com.bookapp.crud.model.graphql.CreateAuthorPayload;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AddAuthorDataFetcher implements DataFetcher<CreateAuthorPayload> {

    @Autowired
    AuthorDao authorDao;

    final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public CreateAuthorPayload get(DataFetchingEnvironment env) throws Exception {
        Map<String, Object> createAuthorInputMap = env.getArgument("author");
        CreateAuthorInput createAuthorInput = objectMapper.convertValue(createAuthorInputMap, CreateAuthorInput.class);

        Author author = new Author();
        author.setFirstName(createAuthorInput.getFirstName());
        author.setLastName(createAuthorInput.getLastName());
        author = authorDao.save(author);

        CreateAuthorPayload createAuthorPayload = new CreateAuthorPayload(author);
        return createAuthorPayload;
    }
}
