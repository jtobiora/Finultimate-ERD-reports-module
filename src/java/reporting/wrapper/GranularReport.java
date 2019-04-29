package reporting.wrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by israel on 5/3/17.
 */
public class GranularReport {
    private String dateTitle;
    private String day;
    private List<ReportItem> reportItems;

    public GranularReport(){
        reportItems = new ArrayList<>();
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<ReportItem> getReportItems() {
        return reportItems;
    }

    public void setReportItems(List<ReportItem> reportItems) {
        this.reportItems = reportItems;
    }

    public String getDateTitle() {
        return dateTitle;
    }

    public void setDateTitle(String dateTitle) {
        this.dateTitle = dateTitle;
    }
}