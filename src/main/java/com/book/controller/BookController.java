package com.book.controller;

import java.util.List;
import com.book.entity.Book;
import com.book.service.BookService;

public class BookController {

    public String addBook(Book b) {
        return BookService.saveBook(b);
    }

    public String updateBook(Book b) {
        return BookService.updateBook(b);
    }

    public String deleteBook(int id) {
        return BookService.deleteBook(id);
    }

    public Book getBookById(int id) {
        return BookService.getBookById(id);
    }

    public List<Book> getAllBooks() {
        return BookService.getAllBooks();
    }
}

