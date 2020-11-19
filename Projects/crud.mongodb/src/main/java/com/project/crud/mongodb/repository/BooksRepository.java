package com.project.crud.mongodb.repository;

import com.project.crud.mongodb.model.Books;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BooksRepository extends MongoRepository<Books,Integer> {



}
