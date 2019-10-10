package com.bookapp.crud.resolver;
/*
import com.bookapp.crud.exception.AuthorNotFoundException;
import com.bookapp.crud.exception.BookNotFoundException;
import com.bookapp.crud.model.Author;
import com.bookapp.crud.model.graphql.CreateAuthorInput;
import com.bookapp.crud.model.Book;
import com.bookapp.crud.model.graphql.CreateBookInput;
import com.bookapp.crud.model.graphql.UpdateAuthorInput;
import com.bookapp.crud.model.graphql.UpdateBookInput;
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

    public Author addAuthor(CreateAuthorInput createAuthorInput){
        Author author = new Author();
        author.setFirstName(createAuthorInput.getFirstName());
        author.setLastName(createAuthorInput.getLastName());
        return authorService.createAuthor(author);
    }
    public Author updateAuthor(UpdateAuthorInput updateAuthorInput){
        Optional<Author> authorOptional = authorService.getAuthor(updateAuthorInput.getId());
        Author author = authorOptional.orElseThrow(() -> new AuthorNotFoundException(updateAuthorInput.getId()));
        author.setFirstName(updateAuthorInput.getFirstName());
        author.setLastName(updateAuthorInput.getLastName());
        return authorService.updateAuthor(author);
    }

    public Book addBook(CreateBookInput createBookInput){
        Book book = new Book();
        book.setTitle(createBookInput.getTitle());
        Optional<Author> authorOptional = authorService.getAuthor(createBookInput.getAuthor().getId());
        Author author = authorOptional.orElseThrow(() -> new AuthorNotFoundException(createBookInput.getAuthor().getId()));
        book.setAuthor(author);
        return bookService.addBook(book);
    }

    public Book updateBook(UpdateBookInput updateBookInput){
        Optional<Book> bookOptional = bookService.getBook(updateBookInput.getId());
        Book book = bookOptional.orElseThrow(() -> new BookNotFoundException(updateBookInput.getId()));
        book.setTitle(updateBookInput.getTitle());
        return bookService.addBook(book);
    }

    public Boolean deleteAuthor(long authorId){
        Optional<Author> authorOptional = authorService.getAuthor(authorId);
        authorOptional.orElseThrow(() -> new AuthorNotFoundException(authorId));
        authorService.deleteAuthor(authorId);
        return true;
    }

    public Boolean deleteBook(long bookId){
        Optional<Book> bookOptional = bookService.getBook(bookId);
        bookOptional.orElseThrow(() -> new BookNotFoundException(bookId));
        bookService.deleteBook(bookId);
        return true;
    }
}

*/
