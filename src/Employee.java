public class Employee extends User{

    Employee(int id , String password , String type){
        super(id , password , type);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
