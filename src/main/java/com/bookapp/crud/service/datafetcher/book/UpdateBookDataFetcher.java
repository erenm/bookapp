package com.bookapp.crud.service.datafetcher.book;

import com.bookapp.crud.dao.BookDao;
import com.bookapp.crud.exception.BookNotFoundException;
import com.bookapp.crud.model.Book;
import com.bookapp.crud.model.graphql.UpdateAuthorInput;
import com.bookapp.crud.model.graphql.UpdateAuthorPayload;
import com.bookapp.crud.model.graphql.UpdateBookInput;
import com.bookapp.crud.model.graphql.UpdateBookPayload;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UpdateBookDataFetcher implements DataFetcher<UpdateBookPayload> {

    @Autowired
    BookDao bookDao;

    final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public UpdateBookPayload get(DataFetchingEnvironment env) throws Exception {
        Map<String, Object> updateBookInputMap = env.getArgument("author");
        UpdateBookInput updateBookInput = objectMapper.convertValue(updateBookInputMap, UpdateBookInput.class);

        long id = updateBookInput.getId();
        Book book = bookDao.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        if(updateBookInput.getTitle() != null){
            book.setTitle(updateBookInput.getTitle());
        }
        book = bookDao.save(book);

        UpdateBookPayload updateBookPayload = new UpdateBookPayload(book);
        return updateBookPayload;
    }
}
