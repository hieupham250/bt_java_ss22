import java.io.File;
import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên tệp: ");
        String filename = sc.nextLine();
        File file = new File(filename);
        if (file.exists()) {
            System.out.println("Tệp đã tồn tại!");
        } else {
            try {
                if (file.createNewFile()) {
                    System.out.println("Tệp đã được tạo!");
                } else {
                    System.out.println("Không thể tạo tệp.");
                }
            } catch (Exception e) {
                System.out.println("Có lỗi xảy ra: " + e.getMessage());
            }
        }
        sc.close();
    }
}
