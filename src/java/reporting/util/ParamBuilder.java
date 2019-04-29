package reporting.util;

public class ParamBuilder {

    private String startDate;
    private String endDate;
    private Integer reportType;
    private String measureType;

    public Integer getReportType() {
        return reportType;
    }

    public void setReportType(Integer reportType) {
        this.reportType = reportType;
    }

    public String getMeasureType() {
        return measureType;
    }

    public void setMeasureType(String measureType) {
        this.measureType = measureType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDateStr) {
        this.startDate = startDateStr;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDateStr) {
        this.endDate = endDateStr;
    }

}
