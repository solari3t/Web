package com.api.idempotent.controller;

import com.api.idempotent.model.Book;
import com.api.idempotent.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/book")
    List<Book> bookList(){
        return bookService.bookList();
    }

    @PostMapping("/book")
    Book insert(@Valid @RequestBody Book book){
        System.out.println(book);
        return bookService.insert(book);
    }

    @DeleteMapping("/book/{id}")
    void delete(@PathVariable Long id){
        bookService.delete(id);
    }
}
