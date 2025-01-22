package com.inEffigo.library_one_to_one.services;

import com.inEffigo.library_one_to_one.entity.Book;
import com.inEffigo.library_one_to_one.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }

    public void deleteBookById(Long id){
        bookRepository.deleteById(id);
    }

}
