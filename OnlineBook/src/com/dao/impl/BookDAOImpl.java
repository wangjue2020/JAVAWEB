package com.dao.impl;

import com.bean.Book;
import com.bean.UserAccount;
import com.dao.BookDAO;

import java.util.List;

public class BookDAOImpl extends  BaseDAO implements BookDAO{
    @Override
    public int addNewBook(Book book) {
        String sql = "insert into Book(`name`, price, author,sales, stock, img_path) values(?,?, ?, ?,?,?)";
        return update(sql, book.getName(), book.getPrice(), book.getAuthor(), book.getSales(), book.getStock(), book.getImg_path());
    }

    @Override
    public int deleteBookById(int id) {
        String sql = "delete from Book where id=?";
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update book set `name`=?, price=?,author=?, sales=?, stock=?, img_path=? where id=?";
        return update(sql, book.getName(), book.getPrice(), book.getAuthor(),book.getSales(),book.getStock(),book.getImg_path(),book.getId());
    }

    @Override
    public Book selectBookById(Integer id) {
        String sql = "select id, `name`, price, author, sales, stock, img_path from book where id=?";
        Book book = selectOne(Book.class, sql, id);
        return book;
    }

    @Override
    public List<Book> selectBooks() {
        String sql="select id, `name`, price, author, sales, stock, img_path from book";
        List<Book> books = selectForList(Book.class, sql);
        return books;
    }
}
