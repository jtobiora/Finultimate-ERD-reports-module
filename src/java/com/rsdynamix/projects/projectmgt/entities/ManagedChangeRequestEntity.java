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
import java.sql.Date;


/**
*
*     @author root
*/
@Entity
@Table(name = "MANAGED_CHANGE_REQUEST")
public class ManagedChangeRequestEntity extends AbstractEntity implements Serializable{

    @Id
    @Column(name = "CHANGE_REQUEST_ID", columnDefinition = "NUMBER(10)")
    private long changeRequestID;
    //
    @Column(name = "CHANGE_REQUEST_NUMBER", columnDefinition = "VARCHAR2(20)")
    private String changeRequestNumber;
    //
    @Column(name = "PRIORITY_TYPE", columnDefinition = "NUMBER(1)")
    private int priorityType;
    //
    @Column(name = "MANAGED_PROJECT_ID", columnDefinition = "NUMBER(10)")
    private long managedProjectID;
    //
    @Column(name = "CHANGE_REQUESTOR_ID", columnDefinition = "NUMBER(10)")
    private int changeRequestorID;
    //
    @Column(name = "CHANGE_SPONSOR_ID", columnDefinition = "NUMBER(10)")
    private int changeSponsorID;
    //
    @Column(name = "REQUEST_DATE", columnDefinition = "DATE")
    private Date requestDate;
    //
    @Column(name = "APPROVAL_STATUS_ID", columnDefinition = "NUMBER(3)")
    private int approvalStatusID;
    //
    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(60)")
    private String approver = "";
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();

    public ManagedChangeRequestEntity() {
        changeRequestID = 0;
        changeRequestNumber = "";
        priorityType = 0;
        managedProjectID = 0;
        changeRequestorID = 0;
        changeSponsorID = 0;
    }
    
    public boolean equals(Object o) {
        return ((o instanceof ManagedChangeRequestEntity)
                && (((ManagedChangeRequestEntity)o).getChangeRequestNumber().equals(
                        this.getChangeRequestNumber())));
    }

    public long getChangeRequestID(){
        return this.changeRequestID;
    }

    public void setChangeRequestID(long changeRequestID){
        this.changeRequestID = changeRequestID;
    }

    public String getChangeRequestNumber(){
        return this.changeRequestNumber;
    }

    public void setChangeRequestNumber(String changeRequestNumber){
        this.changeRequestNumber = changeRequestNumber;
    }

    public int getPriorityType(){
        return this.priorityType;
    }

    public void setPriorityType(int priorityType){
        this.priorityType = priorityType;
    }

    public long getManagedProjectID(){
        return this.managedProjectID;
    }

    public void setManagedProjectID(long managedProjectID){
        this.managedProjectID = managedProjectID;
    }

    public int getChangeRequestorID(){
        return this.changeRequestorID;
    }

    public void setChangeRequestorID(int changeRequestorID){
        this.changeRequestorID = changeRequestorID;
    }

    public int getChangeSponsorID(){
        return this.changeSponsorID;
    }

    public void setChangeSponsorID(int changeSponsorID){
        this.changeSponsorID = changeSponsorID;
    }

    public Date getRequestDate(){
        return this.requestDate;
    }

    public void setRequestDate(Date requestDate){
        this.requestDate = requestDate;
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
