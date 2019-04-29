package reporting.util;

import reporting.domain.Supplier;

public class ReportFormat {

    private Supplier supplier;
    private ReportPull report;

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public ReportPull getReport() {
        return report;
    }

    public void setReport(ReportPull report) {
        this.report = report;
    }
}
