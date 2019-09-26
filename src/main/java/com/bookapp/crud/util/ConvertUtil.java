package com.bookapp.crud.util;

import com.bookapp.crud.dto.AuthorDto;
import com.bookapp.crud.dto.BookDto;
import com.bookapp.crud.model.Author;
import com.bookapp.crud.model.Book;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConvertUtil {
    public AuthorDto convertToAuthorDto(Author author){
        ModelMapper modelMapper = new ModelMapper();
        AuthorDto authorDto = modelMapper.map(author, AuthorDto.class);
        List<BookDto> books = author.getBookList().stream().map(book -> convertToBookDto(book)).collect(Collectors.toList());
        authorDto.setBookDtoList(books);
        return authorDto;
    }

    public Author convertToAuthorEntity(AuthorDto authorDto){
        ModelMapper modelMapper = new ModelMapper();
        Author author = modelMapper.map(authorDto, Author.class);
        List<Book> bookList = authorDto.getBookDtoList().stream().map(bookDto -> convertToBookEntity(bookDto)).collect(Collectors.toList());
        author.setBookList(bookList);
        return author;
    }

    public BookDto convertToBookDto(Book book){
        ModelMapper modelMapper = new ModelMapper();
        BookDto bookDto = modelMapper.map(book, BookDto.class);
        return bookDto;
    }

    public Book convertToBookEntity(BookDto bookDto){
        ModelMapper modelMapper = new ModelMapper();
        Book book = modelMapper.map(bookDto, Book.class);
        return book;
    }

}
