package reporting.util;

import java.util.Date;

/**
 * Created by israel on 5/25/17.
 */
public class FrequencyUtil {

    static int getDays(Date start, Date end){



        return 0;
    }


    static long getChunkSize(String frequency){
        if(frequency.equalsIgnoreCase("Hour")){
            return 1000*60*60;
        }else if(frequency.equalsIgnoreCase("Day")){
            return getChunkSize("Hour")*24;
        }
        return 1000;
    }



}
