/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting.domain;

import com.rsdynamix.abstractobjects.AbstractEntity;
import com.rsdynamix.dynamo.common.entities.BusinessActionTrailEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * @author israel
 */
@Entity
@Table(name="POS_CURRENCY_RECORDS")
public class PosCurrencyRecords extends AbstractEntity implements Serializable{
    @Id
    @Column(name = "CODE", columnDefinition = "Varchar2(255)")
    private String CODE;
    
    @Column(name = "NAME", columnDefinition = "Varchar2(255)")
    private String NAME;
    
    @Column(name = "SYMBOL", columnDefinition = "Varchar2(255)")
    private String SYMBOL;
    
    private transient int approvalStatusID = 0;
    
    private transient String approver = "";
    
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();
    
    public PosCurrencyRecords() {
        CODE = "";
        
    }
    
    

    /**
     * @return the CODE
     */
    public String getCODE() {
        return CODE;
    }

    /**
     * @param CODE the CODE to set
     */
    public void setCODE(String CODE) {
        this.CODE = CODE;
    }

    /**
     * @return the NAME
     */
    public String getNAME() {
        return NAME;
    }

    /**
     * @param NAME the NAME to set
     */
    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    /**
     * @return the SYMBOL
     */
    public String getSYMBOL() {
        return SYMBOL;
    }

    /**
     * @param SYMBOL the SYMBOL to set
     */
    public void setSYMBOL(String SYMBOL) {
        this.SYMBOL = SYMBOL;
    }

    /**
     * @return the approvalStatusID
     */
    public int getApprovalStatusID() {
        return approvalStatusID;
    }

    /**
     * @param approvalStatusID the approvalStatusID to set
     */
    public void setApprovalStatusID(int approvalStatusID) {
        this.approvalStatusID = approvalStatusID;
    }

    /**
     * @return the approver
     */
    public String getApprover() {
        return approver;
    }

    /**
     * @param approver the approver to set
     */
    public void setApprover(String approver) {
        this.approver = approver;
    }

    /**
     * @return the actionTrail
     */
    public BusinessActionTrailEntity getActionTrail() {
        return actionTrail;
    }

    /**
     * @param actionTrail the actionTrail to set
     */
    public void setActionTrail(BusinessActionTrailEntity actionTrail) {
        this.actionTrail = actionTrail;
    }
}
