package bai10;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.addStudent(new Student(1, "Nguyễn Văn A", "Công Nghệ Thông Tin", 3.5));
        manager.addStudent(new Student(2, "Trần Thị B", "Kinh Tế", 3.8));
        manager.addStudent(new Student(3, "Lê Minh C", "Công Nghệ Sinh Học", 2.9));
        manager.addStudent(new Student(4, "Phan Thị D", "Công Nghệ Thông Tin", 3.7));
        manager.saveToFile("students.bin");
        manager.loadFromFile("students.bin");
        System.out.println("\nDanh sách sinh viên:");
        manager.displayAllStudents();
        Student topStudent = manager.findTopStudent();
        if (topStudent != null) {
            System.out.println("\nSinh viên có GPA cao nhất:");
            System.out.println(topStudent);
        }
        List<Student> itStudents = manager.searchByMajor("Công Nghệ Thông Tin");
        System.out.println("\nSinh viên chuyên ngành Công Nghệ Thông Tin:");
        for (Student student : itStudents) {
            System.out.println(student);
        }
        double averageGpa = manager.calculateAverageGpa();
        System.out.println("\nĐiểm trung bình GPA của toàn bộ sinh viên: " + averageGpa);
    }
}
