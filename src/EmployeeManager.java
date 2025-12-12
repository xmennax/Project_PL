import java.io.*;
import java.util.*;

class EmployeeManager {
    private ArrayList<Employee> employees = new ArrayList<>();
    private File file = new File("employees.txt");

    public void addEmployee(Employee e) {
        employees.add(e);
    }
    public void saveToFile() {
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(file, false));
            pw.println("id,password,type");
            for (Employee e : employees) {
                pw.println(e.id + "," + e.password + "," + e.type);
            }

            pw.close();
        } catch (Exception ex) {
            System.out.println("Error saving: " + ex.getMessage());
        }
    }

    public void loadFromFile() {
        employees.clear();
        try {
            if (!file.exists()) return;

            Scanner sc = new Scanner(file);

            if (sc.hasNextLine()) sc.nextLine();

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length < 3) continue;

                int id = Integer.parseInt(parts[0]);
                String password = parts[1];
                String type = parts[2];

                Employee e;
                switch (type) {
                    case "Inventory":
                        e = new InventoryEmployee(id, password);
                        break;
                    case "Marketing":
                        e = new MarketingEmployee(id, password);
                        break;
                    case "Seller":
                        e = new Seller(id, password);
                        break;
                    default:
                        e = new Employee(id, password, type);
                }
                employees.add(e);
            }
            sc.close();
        } catch (Exception ex) {
            System.out.println("Error loading: " + ex.getMessage());
        }
    }

    public void printEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}