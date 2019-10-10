package com.bookapp.crud.service.datafetcher.book;

import com.bookapp.crud.dao.BookDao;
import com.bookapp.crud.model.Book;
import com.bookapp.crud.model.graphql.CreateAuthorPayload;
import com.bookapp.crud.model.graphql.CreateBookInput;
import com.bookapp.crud.model.graphql.CreateBookPayload;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AddBookDataFetcher implements DataFetcher<CreateBookPayload> {
    @Autowired
    BookDao bookDao;

    final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public CreateBookPayload get(DataFetchingEnvironment env) throws Exception {
        Map<String, Object> createBookInputMap = env.getArgument("book");
        CreateBookInput createBookInput = objectMapper.convertValue(createBookInputMap, CreateBookInput.class);

        Book book = new Book();
        book.setTitle(createBookInput.getTitle());
        book.setAuthor(createBookInput.getAuthor());
        book = bookDao.save(book);

        CreateBookPayload createAuthorPayload = new CreateBookPayload(book);
        return createAuthorPayload;
    }
}
