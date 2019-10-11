package com.bookapp.crud.service.datafetcher.author;

import com.bookapp.crud.dao.AuthorDao;
import com.bookapp.crud.exception.AuthorNotFoundException;
import com.bookapp.crud.model.Author;
import com.bookapp.crud.model.graphql.CreateAuthorInput;
import com.bookapp.crud.model.graphql.CreateAuthorPayload;
import com.bookapp.crud.model.graphql.UpdateAuthorInput;
import com.bookapp.crud.model.graphql.UpdateAuthorPayload;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UpdateAuthorDataFetcher implements DataFetcher<UpdateAuthorPayload> {

    @Autowired
    AuthorDao authorDao;

    final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public UpdateAuthorPayload get(DataFetchingEnvironment env) throws Exception {
        Map<String, Object> updateAuthorInputMap = env.getArgument("author");
        UpdateAuthorInput updateAuthorInput = objectMapper.convertValue(updateAuthorInputMap, UpdateAuthorInput.class);

        long id = updateAuthorInput.getId();
        Author author = authorDao.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));

        if(updateAuthorInput.getFirstName() != null){
            author.setFirstName(updateAuthorInput.getFirstName());
        }
        if(updateAuthorInput.getLastName() != null){
            author.setLastName(updateAuthorInput.getLastName());
        }
        author = authorDao.save(author);

        UpdateAuthorPayload updateAuthorPayload = new UpdateAuthorPayload(author);
        return updateAuthorPayload;
    }
}
