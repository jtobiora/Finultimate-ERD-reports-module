package reporting.wrapper;

/**
 * Created by israel on 5/11/17.
 */
public class Summary {
    private String name;
    private Integer integerSummary;
    private Double doubleSummary;
    private Number value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIntegerSummary() {
        return integerSummary;
    }

    public void setIntegerSummary(Integer integerSummary) {
        this.integerSummary = integerSummary;
    }

    public Double getDoubleSummary() {
        return doubleSummary;
    }

    public void setDoubleSummary(Double doubleSummary) {
        this.doubleSummary = doubleSummary;
    }

    public Number getValue() {
        return value;
    }

    public void setValue(Number value) {
        this.value = value;
    }
}
