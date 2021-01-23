package com.test;

import com.bean.Book;
import com.dao.BookDAO;
import com.dao.impl.BookDAOImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BookDAOImplTest {
    private BookDAO bookDAO = new BookDAOImpl();
    @Test
    public void addNewBook() {
        int res = bookDAO.addNewBook(new Book(null, "Name", "Author",12.0,300,300, null));
        System.out.println(res);
    }

    @Test
    public void deleteBookById() {
        int res = bookDAO.deleteBookById(23);
        System.out.println(res);
    }

    @Test
    public void updateBook() {
        int res = bookDAO.updateBook(new Book(23, "Name1", "Author1", 12.0, 300, 300, "static/img/default.jpg"));
        System.out.println(res);
    }

    @Test
    public void selectBookById() {
        Book book = bookDAO.selectBookById(2);
        System.out.println(book);
    }

    @Test
    public void selectBooks() {
        List<Book> books = bookDAO.selectBooks();
        System.out.println(books);
    }
}