/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rsdynamix.projects.projectmgt.entities;

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
@Table(name = "PRIORITY_TYPE")
public class PriorityTypeEntity extends AbstractEntity implements Serializable{

    @Id
    @Column(name = "PRIORITY_TYPE_ID", columnDefinition = "NUMBER(10)")
    private int priorityTypeID;
    //
    @Column(name = "PRIORITY_TYPE_DESC", columnDefinition = "VARCHAR2(30)")
    private String priorityTypeDesc;
    //
    @Column(name = "APPROVAL_STATUS_ID", columnDefinition = "NUMBER(3)")
    private int approvalStatusID;
    //
    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(60)")
    private String approver = "";
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();

    public PriorityTypeEntity() {
        priorityTypeID = 0;
        priorityTypeDesc = "";
    }
    
    public boolean equals(Object o) {
        return ((o instanceof PriorityTypeEntity) 
                && (((PriorityTypeEntity)o).getPriorityTypeDesc().equals(this.getPriorityTypeDesc())));
    }

    public int getPriorityTypeID(){
        return this.priorityTypeID;
    }

    public void setPriorityTypeID(int priorityTypeID){
        this.priorityTypeID = priorityTypeID;
    }

    public String getPriorityTypeDesc(){
        return this.priorityTypeDesc;
    }

    public void setPriorityTypeDesc(String priorityTypeDesc){
        this.priorityTypeDesc = priorityTypeDesc;
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
