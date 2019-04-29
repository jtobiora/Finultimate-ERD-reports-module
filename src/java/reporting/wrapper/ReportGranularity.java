package reporting.wrapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by israel on 5/30/17.
 */
public class ReportGranularity implements Serializable {
    private String start;
    private String end;
    private String frequency;
    List<DateSlice> sliceDate;

    public ReportGranularity(){
        sliceDate = new ArrayList<>();
    }

    public List<DateSlice> getSliceDate() {
        return sliceDate;
    }

    public void setSliceDate(List<DateSlice> sliceDate) {
        this.sliceDate = sliceDate;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
}
