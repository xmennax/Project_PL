 public class ProductTotal {
        protected int productId;
        protected String productName;
        protected double totalPrice;

        ProductTotal(int productId, String productName, double totalPrice) {
            this.productId = productId;
            this.productName = productName;
            this.totalPrice = totalPrice;
        }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
