package com.api.idempotent.service;

import com.api.idempotent.model.Book;

import java.util.List;

public interface BookService {
    List<Book> bookList();

    Book insert(Book book);

    void delete(Long id);
}
