package com.tpe.controller;

import com.tpe.domain.Book;
import com.tpe.dto.BookDTO;
import com.tpe.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController//rest api, return : JSON
//@Controller - dynamaic app, return : ModelAndView veya String(Viewname)
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    @Autowired
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
    public ResponseEntity<String> createBook(@Valid @RequestBody BookDTO bookDTO) {

        bookService.saveBook(bookDTO);

        return new ResponseEntity<>("Kitap basariyla kaydedildi", HttpStatus.CREATED); //201


    }

    //2- Get All Books
    // http://localhost:8080/books + GET
    //todo:ilerleyen derste return:List<BookDTO>
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {

        List<Book> books = bookService.findAllBooks();
        return ResponseEntity.ok(books); //200

    }


    //3- Get a Book by its ID
    // http://localhost:8080/books/2 + GET
    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBook(@PathVariable("id") Long id){
        BookDTO bookDTO=bookService.getBookDTOById(id);

        return ResponseEntity.ok(bookDTO);//200
    }

    //4- Delete a Book by its ID
    // http://localhost:8080/books/2 + DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return ResponseEntity.ok("Kitap silme işlemi başarılı...");
    }








}
