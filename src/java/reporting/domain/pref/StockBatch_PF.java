
package reporting.domain.pref;

import com.rsdynamics.projects.query.operators.EntityOperatorHolder;
import com.rsdynamix.abstractobjects.AbstractEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STOCK_BATCH")
public class StockBatch_PF extends AbstractEntity implements Serializable{
     
    @Id
    @Column(name = "STOCK_BATCH_ID", columnDefinition = "NUMBER(11)")
    private Integer stock_batch_id;
    
    @Column(name = "STOCK_BATCH_NO", columnDefinition = "Varchar2(20)")
    private String stock_batch_no;
    
    @Column(name = "STOCK_BATCH_DATE", columnDefinition = "DATE")
    private Date stock_batch_date;

    @Column(name = "CREATED_BY", columnDefinition = "Varchar2(60)")
    private String created_by;

    @Column(name = "BATCH_NOTE", columnDefinition = "Varchar2(1000)")
    private String batch_note;
    
    @Column(name = "ENTRY_DATE", columnDefinition = "DATE")
    private Date entry_date;
    
    @Column(name = "APPROVAL_STATUS_ID", columnDefinition = "NUMBER(11)")
    private Integer approval_status_id;
    
    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(60)")
    private String approver;

    @Column(name = "TOTAL_ADDED_COST", columnDefinition = "DOUBLE PRECISION")
    private Double total_added_cost;

    @Column(name = "TOTAL_STK_BAT_WT", columnDefinition = "DOUBLE PRECISION")
    private Double total_stk_bat_wt;
    
    @Column(name = "WGTED_AVE_CALC_TYP", columnDefinition = "NUMBER(11)")
    private Integer wgted_ave_calc_typ;

    @Column(name = "WGTED_AVE_STATUS_TYP", columnDefinition = "NUMBER(11)")
    private Integer wgted_ave_status_typ;

    public Integer getStock_batch_id() {
        return stock_batch_id;
    }

    public void setStock_batch_id(Integer stock_batch_id) {
        this.stock_batch_id = stock_batch_id;
    }

    public String getStock_batch_no() {
        return stock_batch_no;
    }

    public void setStock_batch_no(String stock_batch_no) {
        this.stock_batch_no = stock_batch_no;
    }

    public Date getStock_batch_date() {
        return stock_batch_date;
    }

    public void setStock_batch_date(Date stock_batch_date) {
        this.stock_batch_date = stock_batch_date;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getBatch_note() {
        return batch_note;
    }

    public void setBatch_note(String batch_note) {
        this.batch_note = batch_note;
    }

    public Date getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(Date entry_date) {
        this.entry_date = entry_date;
    }

    public Integer getApproval_status_id() {
        return approval_status_id;
    }

    public void setApproval_status_id(Integer approval_status_id) {
        this.approval_status_id = approval_status_id;
    }

    public Double getTotal_added_cost() {
        return total_added_cost;
    }

    public void setTotal_added_cost(Double total_added_cost) {
        this.total_added_cost = total_added_cost;
    }

    public Double getTotal_stk_bat_wt() {
        return total_stk_bat_wt;
    }

    public void setTotal_stk_bat_wt(Double total_stk_bat_wt) {
        this.total_stk_bat_wt = total_stk_bat_wt;
    }

    public Integer getWgted_ave_calc_typ() {
        return wgted_ave_calc_typ;
    }

    public void setWgted_ave_calc_typ(Integer wgted_ave_calc_typ) {
        this.wgted_ave_calc_typ = wgted_ave_calc_typ;
    }

    public Integer getWgted_ave_status_typ() {
        return wgted_ave_status_typ;
    }

    public void setWgted_ave_status_typ(Integer wgted_ave_status_typ) {
        this.wgted_ave_status_typ = wgted_ave_status_typ;
    }

    public EntityOperatorHolder getOperatorHolder() {
        return operatorHolder;
    }

    public void setOperatorHolder(EntityOperatorHolder operatorHolder) {
        this.operatorHolder = operatorHolder;
    }

    
    
    @Override
    public void setApprover(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
