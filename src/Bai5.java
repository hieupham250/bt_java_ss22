import java.io.*;
import java.util.*;

public class Bai5 {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("input.txt"))) {
            writer.write("Văn Lâm\n");
            writer.write("Tiến Linh\n");
            writer.write("Xuân Son\n");
            writer.write("Hoàng Đức\n");
            writer.write("Văn Hậu\n");
            System.out.println("Đã tạo file input.txt với danh sách các cầu thủ.");
        } catch (IOException e) {
            System.out.println("Có lỗi khi tạo file input.txt: " + e.getMessage());
        }
        String longestName = "";
        int maxLength = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.length() > maxLength) {
                    maxLength = line.length();
                    longestName = line;
                }
            }
            System.out.println("Tên cầu thủ dài nhất: " + longestName);
            System.out.println("Độ dài của tên đó: " + maxLength);
        } catch (IOException e) {
            System.out.println("Có lỗi khi đọc file input.txt: " + e.getMessage());
        }
    }
}
