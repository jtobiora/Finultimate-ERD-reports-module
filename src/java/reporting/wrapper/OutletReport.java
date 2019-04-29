package reporting.wrapper;

/**
 * Created by israel on 5/21/17.
 */
public class OutletReport {
    private String outletName;
    private ReportResponse report;

    public String getOutletName() {
        return outletName;
    }

    public void setOutletName(String outletName) {
        this.outletName = outletName;
    }

    public ReportResponse getReport() {
        return report;
    }

    public void setReport(ReportResponse report) {
        this.report = report;
    }
}
