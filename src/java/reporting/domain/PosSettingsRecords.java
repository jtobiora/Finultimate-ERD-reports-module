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
@Table(name = "POS_SETTINGS_RECORDS")
public class PosSettingsRecords extends AbstractEntity implements Serializable {

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER(20)")
    private int posSettingsRecordsID;
    
    @Column(name = "SETTINGS_KEY", columnDefinition = "Varchar2(255)")
    private String settingsKey;
    
    @Column(name = "SETTINGS_VALUE", columnDefinition = "Varchar2(255)")
    private String settingsValue;
    
    
    private transient int approvalStatusID = 0;
    
    private transient String approver = "";
    
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();
    
    public PosSettingsRecords() {
        posSettingsRecordsID = 0;
        
    }

    /**
     * @return the posSettingsRecordsID
     */
    public int getPosSettingsRecordsID() {
        return posSettingsRecordsID;
    }

    /**
     * @param posSettingsRecordsID the posSettingsRecordsID to set
     */
    public void setPosSettingsRecordsID(int posSettingsRecordsID) {
        this.posSettingsRecordsID = posSettingsRecordsID;
    }

    /**
     * @return the settingsKey
     */
    public String getSettingsKey() {
        return settingsKey;
    }

    /**
     * @param settingsKey the settingsKey to set
     */
    public void setSettingsKey(String settingsKey) {
        this.settingsKey = settingsKey;
    }

    /**
     * @return the settingsValue
     */
    public String getSettingsValue() {
        return settingsValue;
    }

    /**
     * @param settingsValue the settingsValue to set
     */
    public void setSettingsValue(String settingsValue) {
        this.settingsValue = settingsValue;
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
