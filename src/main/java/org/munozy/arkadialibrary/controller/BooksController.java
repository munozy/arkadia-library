package org.munozy.arkadialibrary.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.munozy.arkadialibrary.domain.Book;
import org.munozy.arkadialibrary.dto.BookDTO;
import org.munozy.arkadialibrary.dto.PostBookDTO;
import org.munozy.arkadialibrary.repository.BooksRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@Validated
@RestController
@RequestMapping(BooksController.PATH)
@AllArgsConstructor
public class BooksController {

    protected static final String PATH = "/arkadia-library/api/v1/books";

    private final BooksRepository booksRepository;

    @GetMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public  @ResponseBody ResponseEntity<List<BookDTO>> getBooks() {
        List<Book> books = booksRepository.findAll();

        List<BookDTO> bookDTOS = books.stream().map(BookDTO::create).toList();

        return ResponseEntity.ok(bookDTOS);
    }

    @PostMapping(value = "/", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public  @ResponseBody ResponseEntity<BookDTO> insertBook(@RequestBody PostBookDTO postBookDTO) {
        Book newBook = Book.builder()
                .title(postBookDTO.getTitle()).author(postBookDTO.getAuthor())
                .collection(postBookDTO.getCollection()).volume(postBookDTO.getVolume()).build();
        return ResponseEntity.ok(BookDTO.create(booksRepository.save(newBook)));
    }
}
