/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author S3-Developer
 */
public class DateConvert {
    
    public String convertDate(Date myDate) throws ParseException{
        
        //String dateStr = "Mon Jan 02 00:00:00 WAT 2017";
        DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        Date date1 = (Date) formatter.parse(myDate.toString());
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        String formatedDate = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DATE);
        
        return formatedDate;
    }
    
    
    
}
