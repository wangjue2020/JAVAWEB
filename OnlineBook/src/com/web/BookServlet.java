package com.web;

import com.bean.Book;
import com.service.BookService;
import com.service.impl.BookServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet<BookServlet>{
    private BookService bookService = new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void select(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.selectBooks();
        req.setAttribute("books", books);
//        System.out.println(books);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pages/manager/book_manager.jsp");
//        System.out.println(requestDispatcher.);
        requestDispatcher.forward(req, resp);
    }
}
