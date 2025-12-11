import java.time.LocalDate;

public class Offers {
    protected int productID;
    protected int offerID;
    protected double discount;
    protected LocalDate startDate;
    protected LocalDate endDate;
    protected boolean status;

    Offers(int productID , int offerID , double discount , LocalDate startDate , LocalDate endDate , boolean status){
        this.productID = productID;
        this.offerID = offerID;
        this.discount = discount;
        this.startDate = startDate;
        this.endDate  = endDate;
        this.status = status;
    }


    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getOfferID() {
        return offerID;
    }

    public void setOfferID(int offerID) {
        this.offerID = offerID;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isValid() {
        LocalDate today = LocalDate.now();
        return status && (today.isEqual(startDate) || today.isAfter(startDate))
                && (today.isBefore(endDate) || today.isEqual(endDate));
    }

    @Override
    public String toString() {
        return "Offers{" +
                "productID=" + productID +
                ", offerID=" + offerID +
                ", discount=" + discount +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                '}';
    }
}
