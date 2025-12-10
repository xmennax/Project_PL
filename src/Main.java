import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main{
    private ArrayList<Admin> admins = new ArrayList<>();
    private ArrayList<Employee> employees = new ArrayList<>();
    private Admin currentAdmin;

    public void showLoginFrame() {
        JFrame frame = new JFrame("Admin Login / Register");
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(20,20,80,25);
        frame.add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(120,20,160,25);
        frame.add(userField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(20,60,80,25);
        frame.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(120,60,160,25);
        frame.add(passField);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(40,120,100,30);
        frame.add(loginBtn);

        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(160,120,120,30);
        frame.add(registerBtn);

        JLabel message = new JLabel();
        message.setBounds(20,160,300,25);
        message.setForeground(Color.RED);
        frame.add(message);

        loginBtn.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());
            boolean check = false;
            for(Admin a : admins){
                if(a.getUsername().equals(username) && a.getPassword().equals(password)){
                    check = true;
                    currentAdmin = a;
                    frame.dispose();
                    showAdminPanel();
                    break;
                }
            }
            if(!check){
                message.setText("Invalid username or password!");
            }
        });

        registerBtn.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());
            if(password.length()>=6){
                admins.add(new Admin(username,password));
                currentAdmin = admins.get(admins.size()-1);
                message.setText("Admin registered!");
            } else {
                message.setText("Password must be >= 6 characters!");
            }
        });

        frame.setVisible(true);
    }

    public void showAdminPanel(){
        JFrame frame = new JFrame("Admin Panel");
        frame.setSize(500,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JButton changeUserBtn = new JButton("Change Username");
        changeUserBtn.setBounds(20,20,200,30);
        frame.add(changeUserBtn);

        JButton changePassBtn = new JButton("Change Password");
        changePassBtn.setBounds(250,20,200,30);
        frame.add(changePassBtn);

        JButton manageEmpBtn = new JButton("Manage Employees");
        manageEmpBtn.setBounds(20,70,430,30);
        frame.add(manageEmpBtn);

        changeUserBtn.addActionListener(e -> {
            String oldUser = JOptionPane.showInputDialog(frame,"Enter your current username:");
            String newUser = JOptionPane.showInputDialog(frame,"Enter new username:");
            if(oldUser != null && newUser != null){
                if(currentAdmin.getUsername().equals(oldUser)){
                    currentAdmin.setUsername(newUser);
                    JOptionPane.showMessageDialog(frame,"Username changed successfully!");
                } else {
                    JOptionPane.showMessageDialog(frame,"Current username not matched!");
                }
            }
        });

        changePassBtn.addActionListener(e -> {
            String oldPass = JOptionPane.showInputDialog(frame,"Enter your current password:");
            String newPass = JOptionPane.showInputDialog(frame,"Enter new password:");
            if(oldPass != null && newPass != null){
                if(currentAdmin.getPassword().equals(oldPass)){
                    currentAdmin.setPassword(newPass);
                    JOptionPane.showMessageDialog(frame,"Password changed successfully!");
                } else {
                    JOptionPane.showMessageDialog(frame,"Current password not matched!");
                }
            }
        });

        manageEmpBtn.addActionListener(e -> showEmployeePanel());

        frame.setVisible(true);
    }

    public void showEmployeePanel(){
        JFrame frame = new JFrame("Employee Management");
        frame.setSize(600,400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JButton addBtn = new JButton("Add Employee");
        addBtn.setBounds(20,20,150,30);
        frame.add(addBtn);

        JButton deleteBtn = new JButton("Delete Employee");
        deleteBtn.setBounds(200,20,150,30);
        frame.add(deleteBtn);

        JButton updateBtn = new JButton("Update Employee");
        updateBtn.setBounds(380,20,180,30);
        frame.add(updateBtn);

        JButton listBtn = new JButton("List Employees");
        listBtn.setBounds(20,70,200,30);
        frame.add(listBtn);

        JButton searchBtn = new JButton("Search Employee");
        searchBtn.setBounds(250,70,200,30);
        frame.add(searchBtn);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(20,120,540,220);
        textArea.setEditable(false);
        frame.add(textArea);

        addBtn.addActionListener(e -> {
            try{
                int id = Integer.parseInt(JOptionPane.showInputDialog(frame,"Enter ID:"));
                String password = JOptionPane.showInputDialog(frame,"Enter Password:");
                String type = JOptionPane.showInputDialog(frame,"Enter Type:");
                employees.add(new Employee(id,password,type));
                JOptionPane.showMessageDialog(frame,"Employee added!");
            } catch(Exception ex){
                JOptionPane.showMessageDialog(frame,"Invalid input!");
            }
        });

        deleteBtn.addActionListener(e -> {
            try{
                int id = Integer.parseInt(JOptionPane.showInputDialog(frame,"Enter ID to delete:"));
                employees.removeIf(emp -> emp.getId()==id);
                JOptionPane.showMessageDialog(frame,"Employee deleted if existed.");
            } catch(Exception ex){
                JOptionPane.showMessageDialog(frame,"Invalid input!");
            }
        });

        updateBtn.addActionListener(e -> {
            try{
                int id = Integer.parseInt(JOptionPane.showInputDialog(frame,"Enter ID to update:"));
                Employee emp = null;
                for(Employee e1: employees){
                    if(e1.getId()==id){
                        emp=e1;
                        break;
                    }
                }
                if(emp!=null){
                    String[] options = {"Update Password","Update Type"};
                    int choice = JOptionPane.showOptionDialog(frame,"Select option","Update Employee",
                            JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[0]);
                    if(choice==0){
                        String newPass = JOptionPane.showInputDialog(frame,"Enter new password:");
                        emp.setPassword(newPass);
                    } else if(choice==1){
                        String newType = JOptionPane.showInputDialog(frame,"Enter new type:");
                        emp.setType(newType);
                    }
                } else JOptionPane.showMessageDialog(frame,"Employee not found!");
            } catch(Exception ex){
                JOptionPane.showMessageDialog(frame,"Invalid input!");
            }
        });

        listBtn.addActionListener(e -> {
            textArea.setText("");
            int i=1;
            for(Employee e2: employees){
                textArea.append("Employee number "+i+": "+e2.toString()+"\n");
                i++;
            }
        });

        searchBtn.addActionListener(e -> {
            try{
                int id = Integer.parseInt(JOptionPane.showInputDialog(frame,"Enter ID to search:"));
                Employee emp=null;
                for(Employee e3: employees){
                    if(e3.getId()==id){
                        emp=e3;
                        break;
                    }
                }
                if(emp!=null){
                    textArea.setText(emp.toString());
                } else textArea.setText("Employee not found!");
            } catch(Exception ex){
                JOptionPane.showMessageDialog(frame,"Invalid input!");
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> new Main().showLoginFrame());
    }
}