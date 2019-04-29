package reporting.wrapper;

import reporting.domain.PosUsersRecords;

/**
 * Created by israel on 5/17/17.
 */
public class UserReport {
    private PosUsersRecords user;
    private ReportResponse report;

    public PosUsersRecords getUser() {
        return user;
    }

    public void setUser(PosUsersRecords user) {
        this.user = user;
    }

    public ReportResponse getReport() {
        return report;
    }

    public void setReport(ReportResponse report) {
        this.report = report;
    }
}