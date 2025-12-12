import java.io.*;
import java.util.*;

class ProductTotalManager {
    private ArrayList<ProductTotal> totals = new ArrayList<>();
    private File file = new File("product_totals.txt");

    public void updateTotal(Order order) {
        int productId = order.getProduct().getId();
        String productName = order.getProduct().getName();
        double orderTotal = order.getTotalPrice();

        ProductTotal existing = null;
        for (ProductTotal pt : totals) {
            if (pt.getProductId() == productId) {
                existing = pt;
                break;
            }
        }

        if (existing != null) {
            existing.setTotalPrice(existing.getTotalPrice() + orderTotal);
        } else {
            totals.add(new ProductTotal(productId, productName, orderTotal));
        }
    }

    public void saveToFile() {
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(file, false)); // overwrite
            pw.println("productId,productName,totalSales"); // header

            for (ProductTotal pt : totals) {
                pw.println(pt.getProductId() + "," + pt.getProductName() + "," + pt.getTotalPrice());
            }

            pw.close();
        } catch (Exception e) {
            System.out.println("Error saving: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        totals.clear();
        try {
            if (!file.exists()) return;

            Scanner sc = new Scanner(file);

            // تخطي الهيدر
            if (sc.hasNextLine()) sc.nextLine();

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length < 3) continue;

                int productId = Integer.parseInt(parts[0]);
                String productName = parts[1];
                double totalSales = Double.parseDouble(parts[2]);

                totals.add(new ProductTotal(productId, productName, totalSales));
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Error loading: " + e.getMessage());
        }
    }

    public void printTotals() {
        if (totals.isEmpty()) {
            System.out.println("No totals found.");
            return;
        }
        for (ProductTotal pt : totals) {
            System.out.println("Product ID: " + pt.getProductId() +
                    ", Name: " + pt.getProductName() +
                    ", Total Sales: " + pt.getTotalPrice());
        }
    }
}