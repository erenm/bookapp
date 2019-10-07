package com.bookapp.crud.dao;

import com.bookapp.crud.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AuthorDao extends JpaRepository<Author, Long> {

}
