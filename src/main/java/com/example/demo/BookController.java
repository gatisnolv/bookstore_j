package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookRepository repository;
    private final BookResourceAssembler assembler;

    // Aggregate root
    @GetMapping(value = "books", produces = MediaTypes.HAL_JSON_VALUE)
    public CollectionModel<EntityModel<Book>> getAllBooks() {
        List<EntityModel<Book>> books = repository.findAll().stream().map(assembler::toModel).collect(Collectors.toList());
        return CollectionModel.of(books, linkTo(methodOn(BookController.class).getAllBooks()).withSelfRel());
    }

    // Single item
    @GetMapping(value = "books/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public EntityModel<Book> getOneBookById(@PathVariable Long id) {
        Book book = repository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        return assembler.toModel(book);
    }


}
