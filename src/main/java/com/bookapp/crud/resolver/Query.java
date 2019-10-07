package com.bookapp.crud.resolver;

import com.bookapp.crud.model.Author;
import com.bookapp.crud.model.Book;
import com.bookapp.crud.service.AuthorService;
import com.bookapp.crud.service.BookService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    private final AuthorService authorService;
    private final BookService bookService;

    public Query(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    public List<Author> allAuthors(){
        return authorService.getAllAuthors();
    }

    public List<Book> allBooks(){
        return bookService.getAllBooks();
    }
    public List<Book> allBooksByAuthor(DataFetchingEnvironment dataFetchingEnvironment){
        Author author = dataFetchingEnvironment.getArgument("author");
        return bookService.getBooksByAuthor(author);
    }
}
