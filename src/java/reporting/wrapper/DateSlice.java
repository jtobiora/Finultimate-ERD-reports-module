package reporting.wrapper;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by israel on 5/30/17.
 */
public class DateSlice implements Serializable{
    private Date start;
    private Date end;
    private String title;

    public DateSlice() {
        //start = new Date();
        //end = new Date();
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
