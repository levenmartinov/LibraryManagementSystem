package com.tpe.service;

import com.tpe.dto.SaveBookDTO;
import com.tpe.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

}
