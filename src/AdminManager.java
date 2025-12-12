import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
class AdminManager{
    private ArrayList<Admin> admins = new ArrayList<>();
    private File file = new File("admins.txt");

    public void addAdmin(Admin a) {
        admins.add(a);
    }

    public void saveAdminToFile() {
        try {
            boolean fileExists = file.exists();
            PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));

            if (!fileExists) {
                pw.println("username,password");
            }

            for (Admin a : admins) {
                pw.println(a.getUsername() + "," + a.getPassword());
            }

            pw.close();

        } catch (Exception e) {
            System.out.println("Error saving: " + e.getMessage());
        }
    }

    public void loadAdminsFromFile() {
        admins.clear();
        try {
            if (!file.exists()) return;

            Scanner sc = new Scanner(file);

            if (sc.hasNextLine()) {
                String header = sc.nextLine();
                if (!header.contains(",")) {
                    header = sc.nextLine();
                }
            }

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length < 2) continue;

                String username = parts[0];
                String password = parts[1];

                Admin a = new Admin(username, password);
                admins.add(a);
            }

            sc.close();

        } catch (Exception e) {
            System.out.println("Error loading: " + e.getMessage());
        }
    }


    public void updateAdminInFile(String currentUsername , String currentPassword, String newUsername, String newPassword) {
        ArrayList<String> lines = new ArrayList<>();

        try {
            if (!file.exists()) return;
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(",");
                if (parts.length < 2 || line.startsWith("username")) {
                    lines.add(line);
                    continue;
                }

                String username = parts[0];
                String password = parts[1];
                if (username.equals(currentUsername) && password.equals(currentPassword)) {
                    line = newUsername + "," + newPassword;
                }

                lines.add(line);
            }
            sc.close();

            PrintWriter pw = new PrintWriter(new FileOutputStream(file, false));
            for (String l : lines) {
                pw.println(l);
            }
            pw.close();

        } catch (Exception e) {
            System.out.println("Error updating: " + e.getMessage());
        }
    }
    public void printAdmins() {
        if (admins.isEmpty()) {
            System.out.println("No admins found.");
            return;
        }
        for (Admin a : admins) {
            System.out.println(a.getUsername() + " - " + a.getPassword());
        }
    }
}
