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
        String deleteId = req.getParameter("deleteId");
        System.out.println(deleteId);
        bookService.deleteBook(Integer.parseInt(deleteId));
//        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
        select(req, resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void select(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.selectBooks();
        req.setAttribute("books", books);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pages/manager/book_manager.jsp");
        requestDispatcher.forward(req, resp);
    }
}
