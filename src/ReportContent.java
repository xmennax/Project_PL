import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ReportContent {

//    protected ArrayList<ProductTotal> products = new ArrayList<>();
//
//    public String totalPricesPerProduct() {
//        for (ProductTotal p:products) {
//            return p.productId + p.productName + p.totalPrice;
//        }
//        return null;
//    }
//    public ArrayList<ProductTotal> bestSellers(){
//        Collections.sort(products, Comparator.comparingDouble(ProductTotal::getTotalPrice).reversed());
//        return products;
//    }

    protected ArrayList<ProductTotal> products = new ArrayList<>();
    public String totalPricesPerProduct() {
        StringBuilder report = new StringBuilder();
        for (ProductTotal p : products) {
            report.append("ID: ").append(p.getProductId())
                    .append(", Name: ").append(p.getProductName())
                    .append(", Total Price: ").append(p.getTotalPrice())
                    .append("\n");
        }
        return report.toString();
    }
    public ArrayList<ProductTotal> bestSellers(){
        Collections.sort(products, Comparator.comparingDouble(ProductTotal::getTotalPrice).reversed());
        return products;
    }
}
