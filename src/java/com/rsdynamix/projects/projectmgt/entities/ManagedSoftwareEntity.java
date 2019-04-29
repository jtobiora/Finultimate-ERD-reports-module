/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rsdynamix.projects.projectmgt.entities;

import com.rsdynamix.abstractobjects.AbstractEntity;
import com.rsdynamix.dynamo.common.entities.BusinessActionTrailEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
*
*     @author root
*/
@Entity
@Table(name = "MANAGED_SOFTWARE")
public class ManagedSoftwareEntity extends AbstractEntity implements Serializable{

    @Id
    @Column(name = "SOFTWARE_ID", columnDefinition = "NUMBER(10)")
    private int softwareID;
    //
    @Column(name = "SOFTWARE_NAME", columnDefinition = "VARCHAR2(100)")
    private String softwareName;
    //
    private transient List<SoftwareAttributeEntity> attributeList;
    //
    @Column(name = "APPROVAL_STATUS_ID", columnDefinition = "NUMBER(3)")
    private int approvalStatusID;
    //
    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(60)")
    private String approver = "";
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();

    public ManagedSoftwareEntity() {
        softwareID = 0;
        softwareName = "";
        //
        attributeList = new ArrayList<SoftwareAttributeEntity>();
    }
    
    public boolean equals(Object o) {
        return ((o instanceof ManagedSoftwareEntity) 
                && (((ManagedSoftwareEntity)o).getSoftwareName().equals(this.getSoftwareName())));
    }

    public int getSoftwareID(){
        return this.softwareID;
    }

    public void setSoftwareID(int softwareID){
        this.softwareID = softwareID;
    }

    public String getSoftwareName(){
        return this.softwareName;
    }

    public void setSoftwareName(String softwareName){
        this.softwareName = softwareName;
    }

    /**
     * @return the attributeList
     */
    public List<SoftwareAttributeEntity> getAttributeList() {
        return attributeList;
    }

    /**
     * @param attributeList the attributeList to set
     */
    public void setAttributeList(List<SoftwareAttributeEntity> attributeList) {
        this.attributeList = attributeList;
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
