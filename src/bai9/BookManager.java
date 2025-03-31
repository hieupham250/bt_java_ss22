package bai9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private List<Book> bookList;
    private String fileName;

    public BookManager(String fileName) {
        this.fileName = fileName;
        this.bookList = loadBooksFromFile();
    }

    public void addBook(Book book) {
        bookList.add(book);
        saveBooksToFile();
    }

    public void updateBook(Book book) {
        for (Book b : bookList) {
            if (b.getId() == book.getId()) {
                b = book;
                saveBooksToFile();
                return;
            }
        }
    }

    public void deleteBook(int id) {
        bookList.removeIf(book -> book.getId() == id);
        saveBooksToFile();
    }

    public void displayAllBooks() {
        if (bookList.isEmpty()) {
            System.out.println("Danh sách sách trống.");
            return;
        }
        System.out.println("Danh sách các cuốn sách:");
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    private void saveBooksToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(bookList);
        } catch (IOException e) {
            System.out.println("Có lỗi khi lưu sách vào file: " + e.getMessage());
        }
    }

    private List<Book> loadBooksFromFile() {
        List<Book> books = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            books = (List<Book>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Không thể đọc sách từ file: " + e.getMessage());
        }
        return books;
    }
}
