import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ReportContent {

    protected ArrayList<ProductTotal> products = new ArrayList<>();

    public String totalPricesPerProduct() {
        for (ProductTotal p:products) {
            return p.productId + p.productName + p.totalPrice;
        }
        return null;
    }
    public ArrayList<ProductTotal> bestSellers(){
        Collections.sort(products, Comparator.comparingDouble(ProductTotal::getTotalPrice).reversed());
        return products;
    }
}
