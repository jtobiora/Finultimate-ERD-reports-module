package reporting.wrapper;

import reporting.domain.PosUsersRecords;

/**
 * Created by israel on 5/31/17.
 */
public class OutletProductReport {
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
