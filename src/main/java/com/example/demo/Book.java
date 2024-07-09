package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private LocalDate publicationDate;

    Book(String title, String author, String publisher, String publicationDate) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        setPublicationDate(publicationDate);
    }

    public String getPublicationDate() {
        return publicationDate == null ? null : publicationDate.toString();
    }

    public void setPublicationDate(String publicationDate) {
        if (publicationDate == null) {
            return;
        }
        this.publicationDate = LocalDate.parse(publicationDate);
    }

    public boolean allFieldsNull() {
        return title == null && author == null && publisher == null && publicationDate == null;
    }
}
