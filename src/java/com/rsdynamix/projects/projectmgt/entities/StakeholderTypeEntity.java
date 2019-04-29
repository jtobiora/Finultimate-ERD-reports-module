/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rsdynamix.projects.projectmgt.entities;

/**
 *
 * @author p-aniah
 */
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/

import java.io.Serializable;
import com.rsdynamix.abstractobjects.AbstractEntity;
import com.rsdynamix.dynamo.common.entities.BusinessActionTrailEntity;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;


/**
*
*     @author root
*/
@Entity
@Table(name = "STAKEHOLDER_TYPE")
public class StakeholderTypeEntity extends AbstractEntity implements Serializable {

    @Id
    @Column(name = "STAKEHOLDER_TYPE_ID", columnDefinition = "NUMBER(2)")
    private int stakeholderTypeID;
    //
    @Column(name = "STAKEHOLDER_TYPE_DESC", columnDefinition = "VARCHAR2(255)")
    private String stakeholderTypeDesc;
    //
    @Column(name = "APPROVAL_STATUS_ID", columnDefinition = "NUMBER(3)")
    private int approvalStatusID;
    //
    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(60)")
    private String approver = "";
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();

    public StakeholderTypeEntity() {
        stakeholderTypeID = 0;
        stakeholderTypeDesc = "";
    }
    
    public boolean equals(Object o) {
        return ((o instanceof StakeholderTypeEntity) 
                && (((StakeholderTypeEntity)o).getStakeholderTypeDesc().equals(this.getStakeholderTypeDesc())));
    }

    public int getStakeholderTypeID(){
        return this.stakeholderTypeID;
    }

    public void setStakeholderTypeID(int stakeholderTypeID){
        this.stakeholderTypeID = stakeholderTypeID;
    }

    public String getStakeholderTypeDesc(){
        return this.stakeholderTypeDesc;
    }

    public void setStakeholderTypeDesc(String stakeholderTypeDesc){
        this.stakeholderTypeDesc = stakeholderTypeDesc;
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

