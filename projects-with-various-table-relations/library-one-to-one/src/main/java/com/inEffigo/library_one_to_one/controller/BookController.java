package com.inEffigo.library_one_to_one.controller;

import com.inEffigo.library_one_to_one.entity.Book;
import com.inEffigo.library_one_to_one.entity.BookDetails;
import com.inEffigo.library_one_to_one.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    @ResponseBody
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    @ResponseBody
    public String addBook(@RequestBody Book book){
        bookService.saveBook(book);
        return "Book added";
    }

    @RequestMapping(value = "/getBook", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Book> getBookById(@RequestParam Long id){
        return bookService.getBookById(id);
    }

    @RequestMapping(value = "/deleteBook" , method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteBookById(@RequestParam Long id){
        bookService.deleteBookById(id);
        return "Book Deleted";
    }

    @RequestMapping(value = "/getBookDetails", method = RequestMethod.GET)
    @ResponseBody
    public BookDetails getBookDetailsById(Long id){
        Optional<Book> book = bookService.getBookById(id);
        return book.get().getBookDetails();
    }

}
