package com.inEffigo.library_one_to_one.entity;

import jakarta.persistence.*;

@Entity
@Table(schema = "library_db")
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String author;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_details_id" , referencedColumnName = "id")
    private BookDetails bookDetails;

    public Book(){

    }

    public Book(Long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BookDetails getBookDetails() {
        return bookDetails;
    }

    public void setBookDetails(BookDetails bookDetails) {
        this.bookDetails = bookDetails;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", bookDetails=" + bookDetails +
                '}';
    }
}
