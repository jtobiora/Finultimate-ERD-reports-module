package reporting.util;

import java.util.List;

public class ReportPull {

    private List<GranReports> reports;
    private List<ItemDetails> itemDetails;

    public List<ItemDetails> getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(List<ItemDetails> itemDetails) {
        this.itemDetails = itemDetails;
    }

    public List<GranReports> getReports() {
        return reports;
    }

    public void setReports(List<GranReports> reports) {
        this.reports = reports;
    }
}
