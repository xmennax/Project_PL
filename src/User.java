public abstract class User {
    protected int id;
    protected String username;
    protected String password;
    protected String type;

    public User(String username , String password , String type){
        this.username = username;
        this.password = password;
        this.type = type;
    }
    public User(int id , String password , String type){
        this.id = id;
        this.password = password;
        this.type = type;
    }
    public User(int id, String username, String password, String type){
        this.id = id;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    @Override
    public abstract String toString();
}
