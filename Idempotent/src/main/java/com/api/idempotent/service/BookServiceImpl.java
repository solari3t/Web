package com.api.idempotent.service;

import com.api.idempotent.model.Book;
import com.api.idempotent.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService  {
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> bookList(){
        return bookRepository.findAll();
    }

    @Override
    public Book insert(Book book){
        System.out.println(book);
        return bookRepository.save(book);
    }

    @Override
    public void delete(Long id){
        bookRepository.deleteById(id);
    }

}
