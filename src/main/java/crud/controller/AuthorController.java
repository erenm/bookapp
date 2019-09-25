package crud.controller;

import crud.dto.AuthorDto;
import crud.dto.BookDto;
import crud.model.Author;
import crud.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/author")
    public ResponseEntity<Object> getAllAuthors() {
        List<Author> authorList = authorService.getAllAuthors();
        List<AuthorDto> authorDtoList = authorList.stream().map(author -> convertToDto(author)).collect(Collectors.toList());
        return new ResponseEntity<>(authorDtoList, HttpStatus.OK);
    }

    @RequestMapping(value = "/author/{id}")
    public ResponseEntity<AuthorDto> getAuthor(@PathVariable("id") long id) {
        Author author = authorService.getAuthor(id);
        return new ResponseEntity<AuthorDto>(convertToDto(author), HttpStatus.OK);
    }





    private AuthorDto convertToDto(Author author){
        ModelMapper modelMapper = new ModelMapper();
        AuthorDto authorDto = modelMapper.map(author, AuthorDto.class);
        return authorDto;
    }

    private Author convertToEntity(AuthorDto authorDto){
        ModelMapper modelMapper = new ModelMapper();
        Author author = modelMapper.map(authorDto, Author.class);
        return author;
    }


}
