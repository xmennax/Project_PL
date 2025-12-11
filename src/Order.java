public class Order {

    private static int nextId = 1000;
    protected int orderId;
    protected Product product;
    protected int quantity;
    protected int totalPrice;
    protected boolean canceled = false;

    public Order(Product product, int quantity) {
        this.orderId = ++nextId;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = product.getPrice() * quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void cancel() {
        this.canceled = true;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId +
                ", Product: " + product.getName() +
                ", Quantity: " + quantity +
                ", Total Price: " + totalPrice +
                ", Status: " + (canceled ? "Canceled" : "Active");
    }
}