package com.service;

import com.bean.Book;

import java.util.List;

public interface BookService {
    void addBook(Book book);
    void deleteBook(Integer id);
    void updateBook(Book book);
    Book selectBookById(Integer id);
    List<Book> selectBooks();
}
