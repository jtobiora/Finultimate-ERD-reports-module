package reporting.wrapper;

import java.util.Date;

/**
 * Created by israel on 5/2/17.
 */
public class ReportParam {
    private Date startDate;
    private Date endDate;
    private String reportType;
    private String measure;
    private ReportGranularity reportGranularity;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public ReportGranularity getReportGranularity() {
        return reportGranularity;
    }

    public void setReportGranularity(ReportGranularity reportGranularity) {
        this.reportGranularity = reportGranularity;
    }
}
