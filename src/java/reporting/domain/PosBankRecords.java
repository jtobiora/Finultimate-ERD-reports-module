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

@Entity
@Table(name="POS_BANK_RECORDS")
public class PosBankRecords extends AbstractEntity implements Serializable {
    
    @Id
    @Column(name = "BANK_ID", columnDefinition = "NUMBER(20)")
    private int posBankRecordID;
    
    @Id
    @Column(name = "BANK_CODE", columnDefinition = "VARCHAR2(255)")
    private String bankCode;
    
    //
    @Column(name = "bankName", columnDefinition = "VARCHAR2(255)")
    private String bankName;
    
    private transient int approvalStatusID = 0;
    //
    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(60)")
    private transient String approver = "";
    
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();
    
    public PosBankRecords() {
        posBankRecordID = 0;
        
    }
    
    public boolean equals(Object o){
        boolean eqls = false;

        if(o instanceof PosBankRecords) {
            if((((PosBankRecords)o).getPosBankRecordID() > 0) &&
                    (((PosBankRecords)o).getPosBankRecordID() == this.getPosBankRecordID())){
                eqls = true;
            }
        }

        return eqls;
    }

    /**
     * @return the posBankRecordID
     */
    public int getPosBankRecordID() {
        return posBankRecordID;
    }

    /**
     * @param posBankRecordID the posBankRecordID to set
     */
    public void setPosBankRecordID(int posBankRecordID) {
        this.posBankRecordID = posBankRecordID;
    }

    /**
     * @return the bankCode
     */
    public String getBankCode() {
        return bankCode;
    }

    /**
     * @param bankCode the bankCode to set
     */
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    /**
     * @return the bankName
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * @param bankName the bankName to set
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
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

