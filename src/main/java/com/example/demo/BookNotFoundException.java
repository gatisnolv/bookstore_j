package com.example.demo;

public class BookNotFoundException extends RuntimeException {
    BookNotFoundException(Long id) {
        super("Could not find book with id: " + id);
    }

    BookNotFoundException(String name) {
        super("Could not find book with title: '" + name + "'");
    }
}

