import java.time.LocalDate;
import java.util.ArrayList;

public class InventoryEmployee extends Employee implements Arrays<Product>{
    protected ArrayList<Offers> offers = new ArrayList<>();
    protected ArrayList<Product> products = new ArrayList<>();

    InventoryEmployee(int id, String password) {
        super(id, password, "Inventory Employee");
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
    public void decreaseQuantity(int id , int amount){
        Product p = searchProduct(id);
        if(p != null && p.getQuantity()>amount){
            p.setQuantity(p.getQuantity() - amount);
        }
    }
    void receiveOffer(Offers offer) {
        offers.add(offer);
        // System.out.println("Inventory Management received offer: " + offer.description);
    }

    @Override
    public void add(Product p) {
        products.add(p);
    }

    @Override
    public void delete(int id) {
        products.removeIf(e -> e.getId() == (id));
    }

    @Override
    public ArrayList<Product> list() {
        return products;
    }
}