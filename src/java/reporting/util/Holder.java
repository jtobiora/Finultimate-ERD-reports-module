package reporting.util;

public class Holder {

    private Integer id;
    private Integer qtySold;
    private Double revenueEarned;

    public double getRevenueEarned() {
        return revenueEarned;
    }

    public void setRevenueEarned(Double revenueEarned) {
        this.revenueEarned = revenueEarned;
    }

    public Holder(Integer id, Integer qtySold, Double revenueEarned) {
        this.id = id;
        this.qtySold = qtySold;
        this.revenueEarned = revenueEarned;
    }

    public Holder(Integer id, Integer qtySold) {
        this.id = id;
        this.qtySold = qtySold;
    }

    public Holder() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQtySold() {
        return qtySold;
    }

    public void setQtySold(Integer qtySold) {
        this.qtySold = qtySold;
    }

    @Override
    public String toString() {
        return "id=" + id + ", qtySold=" + qtySold + ", Revenue=" + revenueEarned;
    }

}
