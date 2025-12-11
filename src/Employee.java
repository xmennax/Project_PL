public class Employee extends User{
    protected int id;
    protected String password;
    protected String type;

    Employee(int id , String password , String type){
        super(id , password , type);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
