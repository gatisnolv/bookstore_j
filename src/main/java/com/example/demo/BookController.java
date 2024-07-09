package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookController {

    @GetMapping
//    public CollectionModel<EntityModel<Book>> getAllBooks(){
    public String getAllBooks(){
//        return ResponseEntity.ok("hey");
        return "hi";
    }
}
