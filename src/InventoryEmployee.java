import java.time.LocalDate;
import java.util.ArrayList;

public class InventoryEmployee extends Employee{
    protected int id;
    protected String password;
    protected String type;
    protected ArrayList<Product> products=new ArrayList<>();

    InventoryEmployee(int id, String password) {
        super(id, password, "Inventory Employee");
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getType() {
        return type;
    }

    public void addProduct(Product p){
        products.add(p);
    }
    public Product searchProduct(int id){
        for (Product p:products){
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public void deleteProduct(int id) {
        products.removeIf(e -> e.getId() == (id));
    }
    public boolean updateProduct(Product newProduct) {
        for(int i = 0; i < products.size(); i++) {
            if(products.get(i).getId()==(newProduct.getId())) {
                products.set(i, newProduct);
                return true;
            }
        }
        return false;
    }
    public ArrayList<Product>listProduct(){
        return products;
    }
    public ArrayList<Product> lowStock(int limit){
        ArrayList<Product> result = new ArrayList<>();
        for(Product p : products) {
            if(p.getQuantity() <= limit) {
                result.add(p);
            }
        }
        return result;
    }
    public ArrayList<Product> expire(LocalDate date) {
        ArrayList<Product> result = new ArrayList<>();
        for(Product p : products) {
            if(date.isAfter(p.expiryDate)||date.isEqual(p.expiryDate)) {
                result.add(p);
            }
        }
        return result;
    }
    public void increaseQuantity(int id , int amount){
        Product p = searchProduct(id);
        if(p != null){
            p.setQuantity(p.getQuantity() + amount);
        }
    }
}