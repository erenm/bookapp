package crud.service;


import crud.model.Author;
import java.util.List;

public interface AuthorService {
    void addAuthor(Author Author);
    Author getAuthor(long id);
    List<Author> getAllAuthors();
    void deleteAuthor(long id);
    void updateAuthor(Author author);

}
