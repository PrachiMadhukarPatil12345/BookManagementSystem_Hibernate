package com.book.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="books")
public class Book {

    @Id
    private int id;
    private String title;
    private String author;
    private double price;
    private String publisher;

    public Book() {}

    public Book(int id, String title, String author, double price, String publisher) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.publisher = publisher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book [id=" + id +
               ", title=" + title +
               ", author=" + author +
               ", price=" + price +
               ", publisher=" + publisher + "]";
    }
}

