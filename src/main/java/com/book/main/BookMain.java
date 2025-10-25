package com.book.main;

import java.util.List;
import java.util.Scanner;

import com.book.controller.BookController;
import com.book.entity.Book;

public class BookMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookController controller = new BookController();
        int choice;

        System.out.println("📚===========================================================================");
        System.out.println("     BOOK MANAGEMENT SYSTEM     ");
        System.out.println("===========================================================================📚");

        do {
            System.out.println("\nChoose an operation:");
            System.out.println("1️⃣ Add Book");
            System.out.println("2️⃣ Update Book");
            System.out.println("3️⃣ Delete Book");
            System.out.println("4️⃣ View Book by ID");
            System.out.println("5️⃣ View All Books");
            System.out.println("6️⃣ Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter Publisher: ");
                    String publisher = sc.nextLine();

                    Book book = new Book(id, title, author, price, publisher);
                    System.out.println(controller.addBook(book));
                    break;

                case 2:
                    System.out.print("Enter Book ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    Book existingBook = controller.getBookById(uid);
                    if (existingBook == null) {
                        System.out.println("⚠️ No book found with ID: " + uid);
                        break;
                    }

                    System.out.print("Enter new Title (" + existingBook.getTitle() + "): ");
                    existingBook.setTitle(sc.nextLine());

                    System.out.print("Enter new Author (" + existingBook.getAuthor() + "): ");
                    existingBook.setAuthor(sc.nextLine());

                    System.out.print("Enter new Price (" + existingBook.getPrice() + "): ");
                    existingBook.setPrice(sc.nextDouble());
                    sc.nextLine();

                    System.out.print("Enter new Publisher (" + existingBook.getPublisher() + "): ");
                    existingBook.setPublisher(sc.nextLine());

                    System.out.println(controller.updateBook(existingBook));
                    break;

                case 3:
                    System.out.print("Enter Book ID to delete: ");
                    int did = sc.nextInt();
                    System.out.println(controller.deleteBook(did));
                    break;

                case 4:
                    System.out.print("Enter Book ID to view: ");
                    int vid = sc.nextInt();
                    Book b = controller.getBookById(vid);
                    if (b != null)
                        System.out.println("📖 " + b);
                    else
                        System.out.println("⚠️ Book not found!");
                    break;

                case 5:
                    List<Book> list = controller.getAllBooks();
                    if (list.isEmpty()) {
                        System.out.println("⚠️ No books available.");
                    } else {
                        System.out.println("\n📚 All Books:");
                        list.forEach(System.out::println);
                    }
                    break;

                case 6:
                    System.out.println("👋 Exiting... Thank you!");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Try again!");
            }

        } while (choice != 6);

        sc.close();
    }
}

