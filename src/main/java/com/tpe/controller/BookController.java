package com.tpe.controller;

import com.tpe.domain.Book;
import com.tpe.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController//rest api, return : JSON
//@Controller - dynamaic app, return : ModelAndView veya String(Viewname)
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;


    //CREATE
    //1- Save a Book & Response : Message
    // http://localhost:8080/books + POST + body(JSON)
    /*
     { "id":1
       "title":"Martin Eden"
       "author":"Jack London"
       "publicationDate":"1875"
     }

    */
    @PostMapping
    public ResponseEntity<String> createBook(@Valid @RequestBody Book book) {



    }


}
