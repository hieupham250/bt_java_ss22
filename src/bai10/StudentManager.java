package bai10;
import java.io.*;
import java.util.*;

public class StudentManager {
    private List<Student> studentList;

    public StudentManager() {
        studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(studentList);
            System.out.println("Danh sách sinh viên đã được lưu vào file " + filename);
        } catch (IOException e) {
            System.out.println("Có lỗi khi lưu danh sách sinh viên vào file: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            studentList = (List<Student>) ois.readObject();
            System.out.println("Danh sách sinh viên đã được đọc từ file " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Có lỗi khi đọc danh sách sinh viên từ file: " + e.getMessage());
        }
    }

    public Student findTopStudent() {
        if (studentList.isEmpty()) {
            return null;
        }
        Student topStudent = studentList.get(0);
        for (Student student : studentList) {
            if (student.getGpa() > topStudent.getGpa()) {
                topStudent = student;
            }
        }
        return topStudent;
    }

    public List<Student> searchByMajor(String major) {
        List<Student> result = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getMajor().equalsIgnoreCase(major)) {
                result.add(student);
            }
        }
        return result;
    }

    public double calculateAverageGpa() {
        if (studentList.isEmpty()) {
            return 0.0;
        }
        double totalGpa = 0.0;
        for (Student student : studentList) {
            totalGpa += student.getGpa();
        }
        return totalGpa / studentList.size();
    }

    public void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("Danh sách sinh viên trống.");
            return;
        }
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
