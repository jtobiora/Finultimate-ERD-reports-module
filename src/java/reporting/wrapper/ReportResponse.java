package reporting.wrapper;

import java.util.List;

/**
 * Created by israel on 5/12/17.
 */
public class ReportResponse {
    private List<GranularReport> reports;
    private List<Summary> summaries;

    public List<GranularReport> getReports() {
        return reports;
    }

    public void setReports(List<GranularReport> reports) {
        this.reports = reports;
    }

    public List<Summary> getSummaries() {
        return summaries;
    }

    public void setSummaries(List<Summary> summaries) {
        this.summaries = summaries;
    }
}