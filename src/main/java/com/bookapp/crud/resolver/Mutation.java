package com.bookapp.crud.resolver;

import com.bookapp.crud.exception.AuthorNotFoundException;
import com.bookapp.crud.model.Author;
import com.bookapp.crud.model.Book;
import com.bookapp.crud.service.AuthorService;
import com.bookapp.crud.service.BookService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private final AuthorService authorService;
    private final BookService bookService;

    public Mutation(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    public Author addAuthor(String firstName, String lastName){
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        return authorService.createAuthor(author);
    }

    public Book addBook(String title, long authorId){
        Book book = new Book();
        book.setTitle(title);
        Optional<Author> authorOptional = authorService.getAuthor(authorId);
        Author author = authorOptional.orElseThrow(() -> new AuthorNotFoundException(authorId));
        book.setAuthor(author);
        return bookService.addBook(book);
    }
}
