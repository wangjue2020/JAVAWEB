package com.web;

import com.bean.Book;
import com.service.BookService;
import com.service.impl.BookServiceImpl;
import com.utils.WebUtils;

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
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        Book book = bookService.selectBookById(Integer.parseInt(id));
        book = WebUtils.copyParamToBean(req.getParameterMap(), book);
//        Book book = bookService.selectBookById(Integer.parseInt(id));
//        book.setName(req.getParameter("book_name"));
//        book.setAuthor(req.getParameter("book_author"));
//        book.setPrice(Double.valueOf(req.getParameter("book_price")));
//        book.setSales(Integer.parseInt(req.getParameter("book_sales")));
//        book.setStock(Integer.parseInt(req.getParameter("book_stock")));
        bookService.updateBook(book);
        selectOne(req, resp);
    }

    protected void select(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.selectBooks();
        req.setAttribute("books", books);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pages/manager/book_manager.jsp");
        requestDispatcher.forward(req, resp);
    }

    protected void selectOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Book book = bookService.selectBookById(Integer.parseInt(id));
        req.setAttribute("book", book);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pages/manager/book_edit.jsp");
        requestDispatcher.forward(req, resp);
    }
}
