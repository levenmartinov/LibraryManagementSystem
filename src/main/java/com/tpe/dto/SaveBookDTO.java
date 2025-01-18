package com.tpe.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SaveBookDTO {

    @NotBlank(message = "Kitap ismi boşluk olamaz!!!")
    @NotNull(message = "Kitap ismi girilmelidir!!!")
    @Size(min = 2,max = 50,message = "Kitap ismi en az 2 karakter içermelidir!!!!")
    private String title;

    @NotBlank(message = "Yazar ismi boşluk olamaz!!!")
    @Size(min = 2,max = 50,message = "Yazar ismi en az 2 karakter içermelidir!!!!")
    private String author;

    @NotBlank(message = "Lütfen yayın yılını giriniz!")
    private String publicationDate;


    @PostMapping
    public ResponseEntity<String> createBook(@Valid @RequestBody SaveBookDTO bookDTO){

        

        return new ResponseEntity<>("Kitap başarıyla kaydedildi", HttpStatus.CREATED);//201
    }



}