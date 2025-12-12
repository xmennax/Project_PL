import java.io.*;
import java.util.*;

class OrderManager {
    private ArrayList<Order> orders = new ArrayList<>();
    private File file = new File("orders.txt");

    public void addOrder(Order o) {
        orders.add(o);
    }

    public void saveToFile() {
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(file, false)); // overwrite
            pw.println("orderId,productName,quantity,totalPrice,status"); // header

            for (Order o : orders) {
                pw.println(o.getOrderId() + "," +
                        o.getProduct().getName() + "," +
                        o.getQuantity() + "," +
                        o.getTotalPrice() + "," +
                        (o.isCanceled() ? "Canceled" : "Active"));
            }

            pw.close();
        } catch (Exception e) {
            System.out.println("Error saving: " + e.getMessage());
        }
    }


    public void loadFromFile(ProductManager productManager) {
        orders.clear();
        try {
            if (!file.exists()) return;

            Scanner sc = new Scanner(file);

            if (sc.hasNextLine()) sc.nextLine();

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length < 5) continue;

                int orderId = Integer.parseInt(parts[0]);
                String productName = parts[1];
                int quantity = Integer.parseInt(parts[2]);
                int totalPrice = Integer.parseInt(parts[3]);
                String status = parts[4];

                Product product = null;
                for (Product p : productManager.getProducts()) {
                    if (p.getName().equals(productName)) {
                        product = p;
                        break;
                    }
                }

                if (product != null) {
                    Order o = new Order(product, quantity);
                    // نعدل الـ id والـ totalPrice علشان يطابق الفايل
                    o.orderId = orderId;
                    o.totalPrice = totalPrice;
                    if (status.equals("Canceled")) {
                        o.cancel();
                    }
                    orders.add(o);
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Error loading: " + e.getMessage());
        }
    }

    public void printOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
            return;
        }
        for (Order o : orders) {
            System.out.println(o);
        }
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
}