package bai7;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"))) {
            writer.write("\"AU\", \"Australia\"\n");
            writer.write("\"CN\", \"China\"\n");
            writer.write("\"AU\", \"Australia\"\n");
            System.out.println("Đã tạo file data.txt.");
        } catch (IOException e) {
            System.out.println("Có lỗi khi tạo file data.txt: " + e.getMessage());
        }
        List<Country> countryList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            int id = 1;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.replace("\"", "").split(", ");
                String code = parts[0];
                String name = parts[1];
                countryList.add(new Country(id++, code, name));
            }
        } catch (IOException e) {
            System.out.println("Có lỗi khi đọc file data.txt: " + e.getMessage());
        }
        for (Country country : countryList) {
            System.out.println(country);
        }
    }
}

