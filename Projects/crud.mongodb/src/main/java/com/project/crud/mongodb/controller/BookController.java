package com.project.crud.mongodb.controller;

import com.project.crud.mongodb.model.Books;
import com.project.crud.mongodb.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BooksRepository repository;

    @PostMapping("/addBook")
    public String saveBook(@RequestBody Books books)
    {
        repository.save(books);
        return "Added book with Id : "+books.getId();
    }

    @GetMapping("/findAllBooks")
    public List<Books> getBooks()
    {
        return repository.findAll();
    }

    @GetMapping("/findBook/{id}")
    public Optional<Books> getBook(@PathVariable int id)
    {
        return repository.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id){
        repository.deleteById(id);
        return "book deleted with id : " +id;
    }

}
