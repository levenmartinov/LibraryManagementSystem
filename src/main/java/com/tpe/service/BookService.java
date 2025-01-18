package com.tpe.service;

import com.tpe.domain.Book;
import com.tpe.dto.BookDTO;
import com.tpe.exception.BookNotFoundException;
import com.tpe.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    //1-b
    public void saveBook(@Valid BookDTO bookDTO) {

        //bookDTO --> book
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPublicationDate(bookDTO.getPublicationDate());
        bookRepository.save(book);

    }

    //2-b
    public List<Book> findAllBooks() {

        return bookRepository.findAll();

    }

    //3-b
    public Book getBookById(Long id){
        Book book=bookRepository.findById(id).
                orElseThrow(()->new BookNotFoundException("Book not found by id:" + id));
        return book;
    }

    //3-c
    public BookDTO getBookDTOById(Long id) {
        Book book=getBookById(id);
        return new BookDTO(book);
        //alternatif:repositoryde JPQL ile doğrudan DTO objesi de döndürebiliriz.
    }

    //4-b
    public void deleteBook(Long id) {
        getBookById(id);
        bookRepository.deleteById(id);
    }
}
