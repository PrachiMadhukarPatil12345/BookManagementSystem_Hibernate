package com.book.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.book.entity.Book;
import com.book.utility.HibernateUtil;

public class BookDAO {

    public String saveBook(Book book) {
        Session session = HibernateUtil.getHibernateSession();
        Transaction tx = session.beginTransaction();
        session.save(book);
        tx.commit();
        session.close();
        return "✅ Book saved successfully!";
    }

    public String updateBook(Book book) {
        Session session = HibernateUtil.getHibernateSession();
        Transaction tx = session.beginTransaction();
        session.update(book);
        tx.commit();
        session.close();
        return "✅ Book updated successfully!";
    }

    public String deleteBook(int id) {
        Session session = HibernateUtil.getHibernateSession();
        Transaction tx = session.beginTransaction();
        Book book = session.get(Book.class, id);
        if (book != null) {
            session.delete(book);
            tx.commit();
            session.close();
            return "🗑️ Book deleted successfully!";
        } else {
            tx.rollback();
            session.close();
            return "⚠️ Book not found!";
        }
    }

    public Book getBookById(int id) {
        Session session = HibernateUtil.getHibernateSession();
        Book book = session.get(Book.class, id);
        session.close();
        return book;
    }

    @SuppressWarnings("unchecked")
    public List<Book> getAllBooks() {
        Session session = HibernateUtil.getHibernateSession();
        List<Book> list = session.createQuery("from Book").list();
        session.close();
        return list;
    }
}
