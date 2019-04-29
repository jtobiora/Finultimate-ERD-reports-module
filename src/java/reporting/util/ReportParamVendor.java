package reporting.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportParamVendor {
 private String startDate;
 private String endDate;
 
 
 
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
