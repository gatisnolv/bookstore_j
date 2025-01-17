package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

interface BookRepository extends JpaRepository<Book, Long> {
    Book findByTitleIgnoreCase(String title);
}
