package reporting.util;

import java.util.*;
import org.joda.time.*;

/**
 * Created by israel on 5/2/17.
 */
public class DateUtil {

    //1000 = 1 sec
    //1000 * 60 = 1 min
    //1000 * 60 * 60 = 1 hour
    //1000 * 60 * 60 * 24 = 1 day

    public static void main(String... args) {
        DateTime now = new DateTime();
        List<Interval> list = splitDuration(now, now.plusDays(5), 5, 1000*60*60*24);

        for(Interval i : list) {
            System.out.println(i.getStart() + " - " + i.getEnd() + " - " + i.toDurationMillis());
        }
    }

    public static List<Interval> splitDuration(DateTime start, DateTime end, long chunkAmount, long chunkSize) {
        long millis = start.getMillis();
        List<Interval> list = new ArrayList<Interval>();

        for(int i = 0; i < chunkAmount; ++i) {
            list.add(new Interval(millis, millis += chunkSize));
        }

        list.add(new Interval(millis, end.getMillis()));
        return list;
    }

    private static Collection<Interval> splitDuration(Interval interval, int chunks) {
        long startMillis = interval.getStartMillis();
        long endMillis = interval.getEndMillis();
        long durationMillis = endMillis - startMillis;
        long chunkSize = durationMillis / chunks;

        Collection<Interval> list = new ArrayList<Interval>();
        for (int i = 1; i <= chunks; ++i) {
            list.add(new Interval(startMillis, startMillis += chunkSize));
        }

        return list;
    }


    public static Long getFrequencyAmount(String frequency, DateTime dateTime){
        if(frequency.equalsIgnoreCase("day")){
            return new Long(1000*60*60*24);
        }else if(frequency.equalsIgnoreCase("week")){

            return new Long(7*1000*60*60*24);
        }else if(frequency.equalsIgnoreCase("month")){

            return new Long(7*1000*60*60*24);
        }
        return 0l;
    }


    public static int getMonths(Date start, Date end){
        return new Period(start.getTime(), end.getTime()).getMonths();
    }

    public static int getWeeks(Date start, Date end){
        return new Period(start.getTime(), end.getTime()).getWeeks();
    }

    public static int getDays(Date start, Date end){
        return new Interval(start.getTime(), end.getTime()).toPeriod().getDays();
    }

    public static int getHours(Date start, Date end){
        return new Period(start.getTime(), end.getTime()).getHours();
    }


    public long getSeconds(int amount){
        return amount*1000;
    }

    public long getMinute(int amount){
        return 1000*60*amount;
    }

    public long getHour(int amount){
        return 1000*60*60*amount;
    }

    public long getDay(int amount){
        return 1000*60*60*24*amount;
    }

    public long getWeek(int amount){
        return getDay(7*amount);
    }
}
