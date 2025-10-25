package com.book.service;

import java.util.List;
import com.book.dao.BookDAO;
import com.book.entity.Book;

public class BookService {

    private static BookDAO dao = new BookDAO();

    public static String saveBook(Book b) {
        return dao.saveBook(b);
    }

    public static String updateBook(Book b) {
        return dao.updateBook(b);
    }

    public static String deleteBook(int id) {
        return dao.deleteBook(id);
    }

    public static Book getBookById(int id) {
        return dao.getBookById(id);
    }

    public static List<Book> getAllBooks() {
        return dao.getAllBooks();
    }
}

