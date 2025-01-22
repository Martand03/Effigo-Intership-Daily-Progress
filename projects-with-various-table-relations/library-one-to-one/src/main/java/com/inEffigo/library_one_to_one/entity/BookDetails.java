package com.inEffigo.library_one_to_one.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "library_db")
public class BookDetails {

    @Id
    @GeneratedValue
    private Long id;

    private String publicationYear;
    private String description;

    public BookDetails(){

    }

    public BookDetails(Long id, String publicationYear, String description) {
        this.id = id;
        this.publicationYear = publicationYear;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BookDetails{" +
                "id=" + id +
                ", publicationYear='" + publicationYear + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
