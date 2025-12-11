import java.util.ArrayList;

public class MarketingEmployee extends Employee{
    protected int id;
    protected String password;
    protected String type;
    protected ArrayList<Offers> offers = new ArrayList<>();
    protected ArrayList<Report> reports = new ArrayList<>();

    MarketingEmployee(int id, String password) {
        super(id, password, "Marketing Employee");
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

}
