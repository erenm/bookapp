package com.bookapp;

import com.bookapp.crud.resolver.Mutation;
import com.bookapp.crud.resolver.Query;
import com.bookapp.crud.service.AuthorService;
import com.bookapp.crud.service.BookService;
import com.coxautodev.graphql.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLHttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
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

    @Bean
    public ServletRegistrationBean graphQLServlet(){
        return new ServletRegistrationBean(SimpleGraphQLHttpServlet
                .newBuilder(buildSchema(authorService, bookService)).build(),"/graphql");
    }

    private static GraphQLSchema buildSchema(AuthorService authorService, BookService bookService){
        return SchemaParser.newParser()
                .file("graphql/schema.graphqls")
                .resolvers(new Query(authorService, bookService),
                        new Mutation(authorService,bookService))
                .build()
                .makeExecutableSchema();
    }
}
