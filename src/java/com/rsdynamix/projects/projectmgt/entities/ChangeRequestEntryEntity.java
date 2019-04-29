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
 * @author p-aniah
 */
@Entity
@Table(name = "CHANGE_REQUEST_ENTRY")
public class ChangeRequestEntryEntity extends AbstractEntity implements Serializable {
    
    @Id
    @Column(name = "REQUEST_ENTRY_ID", columnDefinition = "NUMBER(10)")
    private long requestEntryID;
    //
    @Column(name = "REQUEST_ENTRY_TITLE", columnDefinition = "VARCHAR2(100)")
    private String requestEntryTitle;
    //
    @Column(name = "CHANGE_REQUEST_TYPE", columnDefinition = "NUMBER(1)")
    private int changeRequestType;
    //
    @Column(name = "REQUEST_ENTRY_DETAIL", columnDefinition = "VARCHAR2(4000)")
    private String requestEntryDetail;
    //
    @Column(name = "CHANGE_REQUEST_ID", columnDefinition = "NUMBER(10)")
    private long changeRequestID;
    //
    @Column(name = "APPROVAL_STATUS_ID", columnDefinition = "NUMBER(3)")
    private int approvalStatusID;
    //
    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(60)")
    private String approver = "";
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();

    public ChangeRequestEntryEntity () {
        requestEntryID = 0;
        changeRequestType = 0;
        requestEntryDetail = "";
        changeRequestID = 0;
    }
    
    public boolean equals(Object o) {
        return ((o instanceof ChangeRequestEntryEntity) 
                && (((ChangeRequestEntryEntity)o).getRequestEntryTitle().equals(this.getRequestEntryTitle())));
    }

    public long getRequestEntryID(){
        return this.requestEntryID;
    }

    public void setRequestEntryID(long requestEntryID){
        this.requestEntryID = requestEntryID;
    }

    public int getChangeRequestType(){
        return this.changeRequestType;
    }

    public void setChangeRequestType(int changeRequestType){
        this.changeRequestType = changeRequestType;
    }

    public String getRequestEntryDetail(){
        return this.requestEntryDetail;
    }

    public void setRequestEntryDetail(String requestEntryDetail){
        this.requestEntryDetail = requestEntryDetail;
    }

    public long getChangeRequestID(){
        return this.changeRequestID;
    }

    public void setChangeRequestID(long changeRequestID){
        this.changeRequestID = changeRequestID;
    }

    /**
     * @return the requestEntryTitle
     */
    public String getRequestEntryTitle() {
        return requestEntryTitle;
    }

    /**
     * @param requestEntryTitle the requestEntryTitle to set
     */
    public void setRequestEntryTitle(String requestEntryTitle) {
        this.requestEntryTitle = requestEntryTitle;
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
