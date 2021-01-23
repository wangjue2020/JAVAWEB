package com.test;

import com.bean.Book;
import com.service.BookService;
import com.service.impl.BookServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BookServiceImplTest {
    private BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "Name", "Author",12.0,300,300, null));
    }

    @Test
    public void deleteBook() {
        bookService.deleteBook(23);
        System.out.println(bookService.selectBookById(23));
    }

    @Test
    public void updateBook() {
        Book book = bookService.selectBookById(23);
        book.setName("New Name");
        book.setAuthor("new author");
        bookService.updateBook(book);
    }

    @Test
    public void selectBookById() {
        Book book = bookService.selectBookById(24);
        System.out.println(book);
    }

    @Test
    public void selectBooks() {
        List<Book> books = bookService.selectBooks();
        System.out.println(books);
    }
}