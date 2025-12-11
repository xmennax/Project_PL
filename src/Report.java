import java.time.LocalDate;
import java.util.ArrayList;

public class Report {
    protected int reportID;
    protected LocalDate reportDate;
    protected ReportContent reportContent;

    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public ReportContent getReportContent() {
        return reportContent;
    }

    public void setReportContent(ReportContent reportContent) {
        this.reportContent = reportContent;
    }
}
