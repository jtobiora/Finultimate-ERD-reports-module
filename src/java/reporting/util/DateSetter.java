package reporting.util;

import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateSetter {
  private Date dateFormatted;
  
  public Date setDateFormat(String dateToFormat){
	  try{
		  dateFormatted = new SimpleDateFormat("yyyy-MM-dd").parse(dateToFormat);
		  return dateFormatted;
	  }catch(Exception ex){
		  ex.getMessage();
		  return null;
	  }
  }
  
  public static long differenceBetweenDays(Date firstDate, Date secondDate){
    try{
    	 return ChronoUnit.DAYS.between(firstDate.toInstant(), secondDate.toInstant());
    }catch(Exception ex){
    	  ex.printStackTrace();
    	  return 0L;
    }
 }
}
