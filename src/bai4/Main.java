package bai4;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Nguyễn Văn A", 20, 8.5);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.bin"))) {
            oos.writeObject(student);
            System.out.println("Đã ghi đối tượng vào file student.bin.");
        } catch (IOException e) {
            System.out.println("Có lỗi khi ghi đối tượng vào file: " + e.getMessage());
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.bin"))) {
            Student readStudent = (Student) ois.readObject();
            System.out.println("Đã đọc đối tượng từ file student.bin.");
            System.out.println("Thông tin của đối tượng đọc được: " + readStudent);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Có lỗi khi đọc đối tượng từ file: " + e.getMessage());
        }
    }
}
