import java.io.*;
import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập một chuỗi văn bản: ");
        String text = sc.nextLine();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write(text);
            writer.close();
            System.out.println("Đã ghi dữ liệu vào file output.txt.");
        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra khi xử lý file: " + e.getMessage());
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {
            String line;
            System.out.println("Nội dung file output.txt:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra khi xử lý file: " + e.getMessage());
        }
    }
}
