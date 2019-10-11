package com.bookapp.crud.controller;

import com.bookapp.crud.service.datafetcher.author.*;
import com.bookapp.crud.service.datafetcher.book.*;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.xml.validation.Schema;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@RestController
public class QueryController {
    private final Logger LOGGER = LoggerFactory.getLogger(QueryController.class);

    private GraphQL graphQL;

    @Value("classpath:graphql/author.graphqls")
    private Resource authorSchema;
    @Value("classpath:graphql/book.graphqls")
    private Resource bookSchema;
    @Value("classpath:graphql/schema.graphqls")
    private Resource allSchema;

    @Autowired
    private AuthorDataFetcher authorDataFetcher;
    @Autowired
    private AuthorListDataFetcher authorListDataFetcher;
    @Autowired
    private AddAuthorDataFetcher addAuthorDataFetcher;
    @Autowired
    private UpdateAuthorDataFetcher updateAuthorDataFetcher;
    @Autowired
    private DeleteAuthorDataFetcher deleteAuthorDataFetcher;

    @Autowired
    private BookDataFetcher bookDataFetcher;
    @Autowired
    private BookListDataFetcher bookListDataFetcher;
    @Autowired
    private AddBookDataFetcher addBookDataFetcher;
    @Autowired
    private UpdateBookDataFetcher updateBookDataFetcher;
    @Autowired
    private DeleteBookDataFetcher deleteBookDataFetcher;


    @PostConstruct
    public void loadSchema() throws IOException {
        SchemaParser schemaParser = new SchemaParser();
        SchemaGenerator schemaGenerator = new SchemaGenerator();

        File schemaFileBook = bookSchema.getFile();
        File schemaFileAuthor = authorSchema.getFile();
        File schemaFileSchema = allSchema.getFile();

        TypeDefinitionRegistry typeDefinitionRegistry = new TypeDefinitionRegistry();
        typeDefinitionRegistry.merge(schemaParser.parse(schemaFileAuthor));
        typeDefinitionRegistry.merge(schemaParser.parse(schemaFileBook));
        typeDefinitionRegistry.merge(schemaParser.parse(schemaFileSchema));

        RuntimeWiring runtimeWiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry,runtimeWiring);
        graphQL = GraphQL.newGraphQL(schema).build();

    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring.dataFetcher("allAuthors", authorListDataFetcher))
                .type("Query", typeWiring -> typeWiring.dataFetcher("allBooks", bookListDataFetcher))
                .type("Query", typeWiring -> typeWiring.dataFetcher("author", authorDataFetcher))
                .type("Query", typeWiring -> typeWiring.dataFetcher("book", bookDataFetcher))
                .type("Mutation", typeWiring -> typeWiring.dataFetcher("addAuthor", addAuthorDataFetcher))
                .type("Mutation", typeWiring -> typeWiring.dataFetcher("addBook", addBookDataFetcher))
                .type("Mutation", typeWiring -> typeWiring.dataFetcher("deleteAuthor", deleteAuthorDataFetcher))
                .type("Mutation", typeWiring -> typeWiring.dataFetcher("deleteBook", deleteBookDataFetcher))
                .build();
    }

    @RequestMapping(value = "/graphql", method= RequestMethod.POST)
    public ResponseEntity query(@RequestBody String query){
        ExecutionResult result = graphQL.execute(query);
        Map<String, Object> toSpecificationResult = result.toSpecification();
        LOGGER.info(String.valueOf(result.getErrors()));
        return ResponseEntity.ok(toSpecificationResult);
    }
}
