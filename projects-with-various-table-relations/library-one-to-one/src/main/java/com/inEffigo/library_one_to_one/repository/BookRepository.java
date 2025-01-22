package com.inEffigo.library_one_to_one.repository;

import com.inEffigo.library_one_to_one.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
