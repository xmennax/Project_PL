import java.time.LocalDate;

public class Product {
    private static int nextId=1000;
    protected int id;
    protected String name;
    protected int quantity;
    protected int price;
    protected LocalDate expiryDate;



    public Product(String name, int quantity, int price,LocalDate expiryDate) {
        this.id = ++nextId;
        this.name = name;
        this.quantity = quantity;
        this.price=price;
        this.expiryDate=expiryDate;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    double applyOffer(Offers offer) {
        if (offer.status) {
            return price - (price * offer.discount / 100);
        }
        return price;
    }



    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", expiryDate=" + expiryDate +
                '}';
    }
}