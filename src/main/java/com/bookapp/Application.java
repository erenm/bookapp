package com.bookapp;

import com.bookapp.crud.service.AuthorService;
import com.bookapp.crud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableAutoConfiguration
@RestController
public class Application {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @RequestMapping("/")
    public String home() {
        return "Hello Docker World";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
