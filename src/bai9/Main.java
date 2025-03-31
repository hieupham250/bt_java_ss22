package bai9;

public class Main {
    public static void main(String[] args) {
        BookManager bookManager = new BookManager("books.bin");
        Book book1 = new Book(1, "Sách 1", "Tác giả 1", "Nhà xuất bản 1", 29.99);
        Book book2 = new Book(2, "Sách 2", "Tác giả 2", "Nhà xuất bản 2", 19.99);
        Book book3 = new Book(3, "Sách 3", "Tác giả 3", "Nhà xuất bản 3", 49.99);
        bookManager.addBook(book1);
        bookManager.addBook(book2);
        bookManager.addBook(book3);
        System.out.println("Hiển thị danh sách sách sau khi thêm:");
        bookManager.displayAllBooks();
        Book updatedBook = new Book(2, "Sách 4", "Tác giả 4", "Nhà xuất bản 4", 25.99);
        bookManager.updateBook(updatedBook);
        System.out.println("Hiển thị danh sách sách sau khi cập nhật:");
        bookManager.displayAllBooks();
        bookManager.deleteBook(1);
        System.out.println("Hiển thị danh sách sách sau khi xóa:");
        bookManager.displayAllBooks();

    }
}
