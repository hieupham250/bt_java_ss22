package bai8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "Sản phẩm A", 100.50));
        productList.add(new Product(2, "Sản phẩm B", 250.75));
        productList.add(new Product(3, "Sản phẩm C", 150.30));
        productList.add(new Product(4, "Sản phẩm D", 300.00));
        productList.add(new Product(5, "Sản phẩm E", 450.20));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("products.bin"))) {
            oos.writeObject(productList);
            System.out.println("Đã ghi danh sách sản phẩm vào file products.bin.");
        } catch (IOException e) {
            System.out.println("Có lỗi khi ghi vào file products.dat: " + e.getMessage());
        }
        List<Product> readProductList = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("products.bin"))) {
            readProductList = (List<Product>) ois.readObject();
            System.out.println("Đã đọc danh sách sản phẩm từ file products.bin.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Có lỗi khi đọc từ file products.bin: " + e.getMessage());
        }
        if (readProductList != null) {
            for (Product product : readProductList) {
                System.out.println(product.formatProduct());
            }
        }
    }
}
