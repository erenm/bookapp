package com.bookapp.crud.controller;

import com.bookapp.crud.model.Author;
import com.bookapp.crud.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {/*
    @Autowired
    private AuthorService authorService;


    @RequestMapping(value = "/author", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllAuthors() {
        List<Author> authorList = authorService.getAllAuthors();
        return new ResponseEntity<>(authorList, HttpStatus.OK);
    }

    @RequestMapping(value = "/author/{id}", method = RequestMethod.GET)
    public ResponseEntity<Author> getAuthor(@PathVariable("id") long id) {
        Author author = authorService.getAuthor(id);
        return new ResponseEntity<AuthorDto>(convertToDto(author), HttpStatus.OK);
    }

    @RequestMapping(value = "/author", method = RequestMethod.POST)
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto) {

        System.out.println("------------***********************----------------------");
        System.out.println(authorDto.getFirstName());
        System.out.println(authorDto.getLastName());
        System.out.println("------------***********************----------------------");


        Author author = convertToEntity(authorDto);
        AuthorDto createdAuthorDto = convertToDto(authorService.createAuthor(author));
        return new ResponseEntity<>(createdAuthorDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/author/", method = RequestMethod.PUT)
    public ResponseEntity<AuthorDto> updateAuthor(@RequestBody AuthorDto authorDto) {
        Author author = convertToEntity(authorDto);
        AuthorDto updatedAuthorDto = convertToDto(authorService.updateAuthor(author));
        return new ResponseEntity<AuthorDto>( updatedAuthorDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/author/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteAuthor(@PathVariable("id") long id) {
        authorService.deleteAuthor(id);
        return new ResponseEntity<>( "Author is deleted successfully" , HttpStatus.OK);
    }

    public AuthorDto convertToDto(Author author){
        AuthorDto authorDto = convertUtil.convertToAuthorDto(author);
        return authorDto;
    }

    public Author convertToEntity(AuthorDto authorDto){
        Author author = convertUtil.convertToAuthorEntity(authorDto);
        return author;
    }
*/









}
