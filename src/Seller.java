import java.util.ArrayList;

public class Seller extends Employee{

    protected int id;
    protected String password;
    protected String type;

    protected InventoryEmployee Inventory;
    protected ArrayList<Order> orders = new ArrayList<>();
    protected ArrayList<ProductTotal> productTotal = new ArrayList<>();

    public Seller(int id, String password) {
        super(id , password , "Seller");
    }
    public void setInventory(InventoryEmployee ProductManager) {
        this.Inventory = ProductManager;
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
    public String getType() {
        return type;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    public Order makeOrder(int productId, int qty) {
        Product p = Inventory.searchProduct(productId);
        if (p == null) {
            return null;
        }
        if (p.getQuantity() < qty) {
            return null;
        }
        for (int i = 0 ; i< productTotal.size() ; i++) {
            if(productTotal.get(i).productId == productId){
                double total = (p.price*qty)+productTotal.get(i).totalPrice;
                productTotal.set(i,new ProductTotal(p.getId() , p.getName() ,  total));
            }
        }
        Inventory.lowStock(productId);
        Order order = new Order(p, qty);
        orders.add(order);
        return order;
    }
    public void cancelOrder(int orderId) {

        for (Order o : orders) {

            if (o.getOrderId() == orderId && !o.isCanceled()) {
                Inventory.increaseQuantity(o.getProduct().getId(), o.getQuantity());

                o.cancel();
                return;
            }
            for (int i = 0 ; i< productTotal.size() ; i++) {
                if(productTotal.get(i).productId == o.getProduct().getId()){
                    double total = productTotal.get(i).totalPrice-(o.getProduct().price*o.getProduct().getQuantity());
                    productTotal.set(i,new ProductTotal(o.getProduct().getId() , o.getProduct().getName() ,  total));
                }
            }
        }
    }

    public void listOrders() {
        for (Order o : orders) {
            System.out.println(o);
        }
    }
}