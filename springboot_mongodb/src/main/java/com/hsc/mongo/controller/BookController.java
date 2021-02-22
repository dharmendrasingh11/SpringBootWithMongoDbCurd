package com.hsc.mongo.controller;

import com.hsc.mongo.model.Book;
import com.hsc.mongo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @PostMapping("/addBook")
    public ResponseEntity<Book> createBookDetails(@RequestBody Book book) {
        Book save = bookRepository.save(book);
        return new ResponseEntity(save, HttpStatus.OK);
    }

    @GetMapping("/getBookList")
    public ResponseEntity<List<Book>> getBookList() {

        return new ResponseEntity(bookRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public Optional<Book> getBookFindId(@PathVariable int id) {
        Optional<Book> byId = bookRepository.findById(id);
        return byId;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        bookRepository.deleteById(id);
        return "book deleted by id : " + id;

    }
}
