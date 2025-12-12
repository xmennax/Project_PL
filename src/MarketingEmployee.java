import java.util.ArrayList;

public class MarketingEmployee extends Employee{
    protected ArrayList<Offers> offers = new ArrayList<>();
    protected ArrayList<Report> reports = new ArrayList<>();

    MarketingEmployee(int id, String password) {
        super(id, password, "Marketing Employee");
    }

    public void createReport(Report r) {

        reports.add(r);
    }
    public void createSpecialOffer(Offers o) {

        offers.add(o);
    }

    public ArrayList<Offers> displayOffers() {
        return offers;
    }
    public ArrayList<Report> displayReports() {
        return reports;
    }


    void sendOfferToInventory(Offers offer, InventoryEmployee inventory) {
        //System.out.println(id + " Employee sent offer to Inventory Management.");
        inventory.receiveOffer(offer);
    }


}
