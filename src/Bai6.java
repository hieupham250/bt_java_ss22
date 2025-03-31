import java.io.*;

public class Bai6 {
    public static void main(String[] args) {
        String content = "Tôi là Hiếu nè";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("input.txt"))) {
            writer.write(content);
            System.out.println("Đã tạo file input.txt với nội dung văn bản có sẵn.");
        } catch (IOException e) {
            System.out.println("Có lỗi khi tạo file input.txt: " + e.getMessage());
        }
        StringBuilder reversedContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                reversedContent.append(new StringBuilder(line).reverse().toString()).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Có lỗi khi đọc file input.txt: " + e.getMessage());
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("copy.txt"))) {
            writer.write(reversedContent.toString());
            System.out.println("Đã ghi nội dung chuỗi đã đảo ngược vào file copy.txt.");
        } catch (IOException e) {
            System.out.println("Có lỗi khi ghi vào file copy.txt: " + e.getMessage());
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("copy.txt"))) {
            String line;
            System.out.println("\nNội dung của file copy.txt:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Có lỗi khi đọc file copy.txt: " + e.getMessage());
        }
    }
}
