import java.util.ArrayList;

public class Admin extends User implements Arrays<Employee>{
    protected ArrayList<Employee> employees = new ArrayList<>();

    Admin(String username, String password) {
        super(username, password, "Admin");
    }

    public void changeCredentials(String newUsername, String newPassword) {
        setUsername(newUsername);
        setPassword(newPassword);
    }

    @Override
    public void add(Employee e) {
        for (Employee em : employees) {
            if (em.getId() == id) {
                return;
            }
        }
        employees.add(e);
    }

    @Override
    public ArrayList<Employee> list() {
        return employees;
    }


    @Override
    public void delete(int id) {
        employees.removeIf(emp -> emp.id == id);
    }

    public void updateEmployee(int id, String newPassword) {
        for (Employee emp : employees) {
            if (emp.id == id) {
                emp.password = newPassword;
            }
        }
    }

    public void listEmployees() {
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    public Employee searchEmployee(int id) {
        for (Employee emp : employees) {
            if (emp.id == id) return emp;
        }
        return null;
    }


    @Override
    public String toString() {
        return "Admin{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}