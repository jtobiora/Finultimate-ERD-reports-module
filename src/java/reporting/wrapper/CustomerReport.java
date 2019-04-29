package reporting.wrapper;

import reporting.domain.PosCustomerRecords;

/**
 * Created by israel on 5/21/17.
 */
public class CustomerReport {
    private PosCustomerRecords customer;
    private ReportResponse report;

    public PosCustomerRecords getCustomer() {
        return customer;
    }

    public void setCustomer(PosCustomerRecords customer) {
        this.customer = customer;
    }

    public ReportResponse getReport() {
        return report;
    }

    public void setReport(ReportResponse report) {
        this.report = report;
    }
}
