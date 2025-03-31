import java.io.*;

public class Bai3 {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("input.txt"))) {
            writer.write("Phạm Trung Hiếu Sẽ được sao chép vào file copy.txt.");
            System.out.println("Đã tạo và ghi nội dung vào file input.txt.");
        }catch (IOException e) {
            System.out.println("Có lỗi xảy ra khi ghi vào input.txt: " + e.getMessage());
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("copy.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra khi sao chép nội dung: " + e.getMessage());
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("copy.txt"))) {
            String line;
            System.out.println("Nội dung của file copy.txt:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra khi đọc file copy.txt: " + e.getMessage());
        }
    }
}
