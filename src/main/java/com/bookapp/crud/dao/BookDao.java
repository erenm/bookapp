package com.bookapp.crud.dao;

import com.bookapp.crud.model.Author;
import com.bookapp.crud.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface BookDao extends JpaRepository<Book, Long> {
    @Query("SELECT book FROM Book book WHERE book.author=(:author)")
    List<Book> findBooksByAuthor(Author author);
}
