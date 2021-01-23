package com.dao;

import com.bean.Book;

import java.util.List;

public interface BookDAO {
    int addNewBook(Book book);
    int deleteBookById(int id);
    int updateBook(Book book);
    Book selectBookById(Integer id);
    List<Book> selectBooks();
}
