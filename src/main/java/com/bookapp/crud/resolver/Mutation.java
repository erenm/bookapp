package com.bookapp.crud.resolver;

import com.bookapp.crud.model.Author;
import com.bookapp.crud.model.AuthorInput;
import com.bookapp.crud.model.Book;
import com.bookapp.crud.model.BookInput;
import com.bookapp.crud.service.AuthorService;
import com.bookapp.crud.service.BookService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    private final AuthorService authorService;
    private final BookService bookService;

    public Mutation(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    public Author addAuthor(AuthorInput authorInput){
        Author author = new Author();
        author.setFirstName(authorInput.getFirstName());
        author.setLastName(authorInput.getLastName());
        return authorService.createAuthor(author);
    }

    public Book addBook(BookInput bookInput){
        Book book = new Book();
        book.setTitle(bookInput.getTitle());
        book.setAuthor(bookInput.getAuthor());
        return bookService.addBook(book);
    }
}
