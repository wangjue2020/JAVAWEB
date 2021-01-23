package com.service.impl;

import com.bean.Book;
import com.dao.BookDAO;
import com.dao.impl.BookDAOImpl;
import com.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService{
    private BookDAO bookDAO = new BookDAOImpl();
    @Override
    public void addBook(Book book) {
        int res = bookDAO.addNewBook(book);
    }

    @Override
    public void deleteBook(Integer id) {
        int res = bookDAO.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        int res = bookDAO.updateBook(book);
    }

    @Override
    public Book selectBookById(Integer id) {
        return bookDAO.selectBookById(id);
    }

    @Override
    public List<Book> selectBooks() {
        return bookDAO.selectBooks();
    }
}
