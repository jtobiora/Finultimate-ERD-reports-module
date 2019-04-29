package reporting.report;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import reporting.util.DateUtil;
import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.util.Calendar;
import java.util.List;
import java.util.Date;

/**
 * Created by israel on 5/2/17.
 */
public class SalesReport {

    public static void generateDailySalesReport(String measure, DateTime start, DateTime end) throws ParseException {
        /*  int days = (int)new Interval(start.getMillis(), end.getMillis()).toDuration().getStandardDays();
        System.out.println(days);
        List<Interval> intervalList = DateUtil.splitDuration(start, end, days, 1000*60*60*24);
        System.out.println(intervalList.size());

        Date st = new Date();

        System.out.println(intervalList.get(0).getStart().getDayOfMonth());
        System.out.println(intervalList.get(7).getStart());

        System.out.println(getOrdinal(intervalList.get(0).getStart().getDayOfMonth())+" "+getMonthName(intervalList.get(0).getStart().getMonthOfYear()));
        System.out.println(getOrdinal(intervalList.get(7).getStart().getDayOfMonth())+" "+getMonthName(intervalList.get(7).getStart().getMonthOfYear()));

        System.out.println(intervalList.get(7).getStart().getMonthOfYear());*/
        String dateStr = "Mon Jun 18 00:00:00 IST 2012";
        DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        Date date = (Date) formatter.parse(dateStr);
        System.out.println(date);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
        System.out.println("formatedDate : " + formatedDate);
    }

    //public static void main(String[] args){
    //generateDailySalesReport("Basket Size", new DateTime(), new DateTime().plusDays(7));
    //}
    public static String getOrdinal(int dayOfMonth) {
        switch (dayOfMonth) {
            case 1:
                return "1st";
            case 2:
                return "2nd";
            case 3:
                return "3rd";
            case 4:
                return "4th";
            case 5:
                return "5th";
            case 6:
                return "6th";
            case 7:
                return "7th";
            case 8:
                return "8th";
            case 9:
                return "9th";
            case 10:
                return "10th";
            case 11:
                return "11th";
            case 12:
                return "12th";
            case 13:
                return "13th";
            case 14:
                return "14th";
            case 15:
                return "15th";
            case 16:
                return "16th";
            case 17:
                return "17th";
            case 18:
                return "18th";
            case 19:
                return "19th";
            case 20:
                return "20th";
            case 21:
                return "21st";
            case 22:
                return "22nd";
            case 23:
                return "23rd";
            case 24:
                return "24th";
            case 25:
                return "25th";
            case 26:
                return "26th";
            case 27:
                return "27th";
            case 28:
                return "28th";
            case 29:
                return "29th";
            case 30:
                return "30th";
            case 31:
                return "31st";
            default:
                return "";
        }
    }

    public static String getOrdinal(Date day) {
        return getOrdinal(new DateTime(day).getDayOfMonth());
    }

    public static String getDayName(Date day) {
        return new DateTime(day).dayOfWeek().getAsShortText();
    }

    public static String getMonthName(int monthOfYear) {
        switch (monthOfYear) {
            case 1:
                return "Jan";
            case 2:
                return "Feb";
            case 3:
                return "Mar";
            case 4:
                return "Apr";
            case 5:
                return "May";
            case 6:
                return "Jun";
            case 7:
                return "Jul";
            case 8:
                return "Aug";
            case 9:
                return "Sep";
            case 10:
                return "Oct";
            case 11:
                return "Nov";
            case 12:
                return "Dec";
            default:
                return "";
        }
    }

    public static String getMonthName(Date month) {
        return getMonthName(new DateTime(month).getMonthOfYear());
    }

    public static void main(String[] args) {
        System.out.println(getDayName(new Date()));
    }

}
