/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting.domain;

import com.rsdynamics.projects.query.operators.EntityOperatorHolder;
import com.rsdynamix.abstractobjects.AbstractEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author S3-Developer
 */
@Entity
@Table(name="STOCK_BATCH")
public class StockBatch extends AbstractEntity implements Serializable {
    
    @Id
    @Column(name = "STOCK_BATCH_ID", columnDefinition = "NUMBER(11)")
    private int stock_batch_id;
    
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
    private int approval_status_id;
    
    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(60)")
    private String approver;

    @Column(name = "TOTAL_ADDED_COST", columnDefinition = "DOUBLE PRECISION")
    private double total_added_cost;

    @Column(name = "TOTAL_STK_BAT_WT", columnDefinition = "DOUBLE PRECISION")
    private double total_stk_bat_wt;
    
    @Column(name = "WGTED_AVE_CALC_TYP", columnDefinition = "NUMBER(11)")
    private int wgted_ave_calc_typ;

    @Column(name = "WGTED_AVE_STATUS_TYP", columnDefinition = "NUMBER(11)")
    private int wgted_ave_status_typ;
    
    public StockBatch(){
        
    }

    public int getStock_batch_id() {
        return stock_batch_id;
    }

    public void setStock_batch_id(int stock_batch_id) {
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

    public int getApproval_status_id() {
        return approval_status_id;
    }

    public void setApproval_status_id(int approval_status_id) {
        this.approval_status_id = approval_status_id;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public double getTotal_added_cost() {
        return total_added_cost;
    }

    public void setTotal_added_cost(double total_added_cost) {
        this.total_added_cost = total_added_cost;
    }

    public double getTotal_stk_bat_wt() {
        return total_stk_bat_wt;
    }

    public void setTotal_stk_bat_wt(double total_stk_bat_wt) {
        this.total_stk_bat_wt = total_stk_bat_wt;
    }

    public int getWgted_ave_calc_typ() {
        return wgted_ave_calc_typ;
    }

    public void setWgted_ave_calc_typ(int wgted_ave_calc_typ) {
        this.wgted_ave_calc_typ = wgted_ave_calc_typ;
    }

    public int getWgted_ave_status_typ() {
        return wgted_ave_status_typ;
    }

    public void setWgted_ave_status_typ(int wgted_ave_status_typ) {
        this.wgted_ave_status_typ = wgted_ave_status_typ;
    }

    public EntityOperatorHolder getOperatorHolder() {
        return operatorHolder;
    }

    public void setOperatorHolder(EntityOperatorHolder operatorHolder) {
        this.operatorHolder = operatorHolder;
    }

    @Override
    public String toString() {
        return "stock_batch_id=" + stock_batch_id;
    }

    
   
}
