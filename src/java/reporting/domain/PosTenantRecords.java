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
@Table(name = "POS_TENANT_RECORDS")
public class PosTenantRecords extends AbstractEntity implements Serializable {

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER(20)")
    private int posTenantRecordsID;

    @Column(name = "TENANT_LOGO", columnDefinition = "BLOB")
    private byte tenantLogo;

    @Column(name = "OUTLET_NAME", columnDefinition = "Varchar2(255)")
    private String outletName;

    @Column(name = "TENANT_NAME", columnDefinition = "Varchar2(255)")
    private String tenantName;
    
    private transient int approvalStatusID = 0;
    
    private transient String approver = "";
    
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();
    
    public PosTenantRecords() {
        posTenantRecordsID = 0;
        
    }

    /**
     * @return the posTenantRecordsID
     */
    public int getPosTenantRecordsID() {
        return posTenantRecordsID;
    }

    /**
     * @param posTenantRecordsID the posTenantRecordsID to set
     */
    public void setPosTenantRecordsID(int posTenantRecordsID) {
        this.posTenantRecordsID = posTenantRecordsID;
    }

    /**
     * @return the tenantLogo
     */
    public byte getTenantLogo() {
        return tenantLogo;
    }

    /**
     * @param tenantLogo the tenantLogo to set
     */
    public void setTenantLogo(byte tenantLogo) {
        this.tenantLogo = tenantLogo;
    }

    /**
     * @return the outletName
     */
    public String getOutletName() {
        return outletName;
    }

    /**
     * @param outletName the outletName to set
     */
    public void setOutletName(String outletName) {
        this.outletName = outletName;
    }

    /**
     * @return the tenantName
     */
    public String getTenantName() {
        return tenantName;
    }

    /**
     * @param tenantName the tenantName to set
     */
    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
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
