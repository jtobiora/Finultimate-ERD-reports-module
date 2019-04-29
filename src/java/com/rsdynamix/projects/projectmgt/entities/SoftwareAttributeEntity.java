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
@Table(name = "SOFTWARE_ATTRIBUTE")
public class SoftwareAttributeEntity extends AbstractEntity implements Serializable{

    @Id
    @Column(name = "ATTRIBUTE_ID", columnDefinition = "NUMBER(10)")
    private long attributeID;
    //
    @Column(name = "ATTRIBUTE_NAME", columnDefinition = "VARCHAR2(100)")
    private String attributeName;
    //
    @Column(name = "ATTRIBUTE_VALUE", columnDefinition = "VARCHAR2(100)")
    private String attributeValue;
    //
    @Column(name = "MANAGED_SOFTWARE_ID", columnDefinition = "NUMBER(10)")
    private long managedSoftwareID;
    //
    @Column(name = "APPROVAL_STATUS_ID", columnDefinition = "NUMBER(3)")
    private int approvalStatusID;
    //
    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(60)")
    private String approver = "";
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();

    public SoftwareAttributeEntity() {
        attributeID = 0;
        attributeName = "";
        managedSoftwareID = 0;
        attributeValue = "";
    }
    
    public boolean equals(Object o) {
        return ((o instanceof SoftwareAttributeEntity) 
                && (((SoftwareAttributeEntity)o).getAttributeName().equals(this.getAttributeName()))
                && (((SoftwareAttributeEntity)o).getManagedSoftwareID() == this.getManagedSoftwareID()));
    }

    public long getAttributeID(){
        return this.attributeID;
    }

    public void setAttributeID(long attributeID){
        this.attributeID = attributeID;
    }

    public String getAttributeName(){
        return this.attributeName;
    }

    public void setAttributeName(String attributeName){
        this.attributeName = attributeName;
    }

    public String getAttributeValue(){
        return this.attributeValue;
    }

    public void setAttributeValue(String attributeValue){
        this.attributeValue = attributeValue;
    }

    public long getManagedSoftwareID(){
        return this.managedSoftwareID;
    }

    public void setManagedSoftwareID(long managedSoftwareID){
        this.managedSoftwareID = managedSoftwareID;
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
