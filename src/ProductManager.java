import java.io.*;
import java.time.LocalDate;
import java.util.*;

class ProductManager {
    private ArrayList<Product> products = new ArrayList<>();
    private File file = new File("products.txt");

    public void addProduct(Product p) {
        products.add(p);
    }

    public void saveToFile() {
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(file, false)); // overwrite
            pw.println("id,name,quantity,price,expiryDate"); // header

            for (Product p : products) {
                pw.println(p.getId() + "," + p.getName() + "," + p.getQuantity() + "," +
                        p.getPrice() + "," + p.getExpiryDate());
            }

            pw.close();
        } catch (Exception e) {
            System.out.println("Error saving: " + e.getMessage());
        }
    }
    public void loadFromFile() {
        products.clear();
        try {
            if (!file.exists()) return;

            Scanner sc = new Scanner(file);

            // تخطي الهيدر
            if (sc.hasNextLine()) sc.nextLine();

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length < 5) continue;

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int quantity = Integer.parseInt(parts[2]);
                int price = Integer.parseInt(parts[3]);
                LocalDate expiryDate = LocalDate.parse(parts[4]);

                Product p = new Product(name, quantity, price, expiryDate);
                p.setId(id); // نحافظ على نفس الـ id من الفايل
                products.add(p);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Error loading: " + e.getMessage());
        }
    }
    public ArrayList<Product> getProducts() {
        return products;
    }
    public void printProducts() {
        if (products.isEmpty()) {
            System.out.println("No products found.");
            return;
        }
        for (Product p : products) {
            System.out.println(p);
        }
    }
}