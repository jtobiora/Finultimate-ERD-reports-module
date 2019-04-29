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
@Table(name = "PROJECT_ATTRIBUTE")
public class ProjectAttributeEntity extends AbstractEntity implements Serializable{

    @Id
    @Column(name = "PROJECT_ATTRIBUTE_ID", columnDefinition = "NUMBER(10)")
    private long projectAttributeID;
    //
    @Column(name = "PROJECT_ATTRIBUTE_NAME", columnDefinition = "VARCHAR2(100)")
    private String projectAttributeName;
    //
    @Column(name = "PROJECT_ATTRIBUTE_VALUE", columnDefinition = "VARCHAR2(100)")
    private String projectAttributeValue;
    //
    @Column(name = "MANAGED_PROJECT_ID", columnDefinition = "NUMBER(10)")
    private long managedProjectID;
    //
    @Column(name = "APPROVAL_STATUS_ID", columnDefinition = "NUMBER(3)")
    private int approvalStatusID;
    //
    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(60)")
    private String approver = "";
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();

    public ProjectAttributeEntity() {
        projectAttributeID = 0;
        projectAttributeName = "";
        projectAttributeValue = "";
        managedProjectID = 0;
    }
    
    public boolean equals(Object o) {
        return ((o instanceof ProjectAttributeEntity) 
                && (((ProjectAttributeEntity)o).getProjectAttributeName().equals(
                        this.getProjectAttributeName())));
    }

    public long getProjectAttributeID(){
        return this.projectAttributeID;
    }

    public void setProjectAttributeID(long projectAttributeID){
        this.projectAttributeID = projectAttributeID;
    }

    public String getProjectAttributeName(){
        return this.projectAttributeName;
    }

    public void setProjectAttributeName(String projectAttributeName){
        this.projectAttributeName = projectAttributeName;
    }

    public String getProjectAttributeValue(){
        return this.projectAttributeValue;
    }

    public void setProjectAttributeValue(String projectAttributeValue){
        this.projectAttributeValue = projectAttributeValue;
    }

    public long getManagedProjectID(){
        return this.managedProjectID;
    }

    public void setManagedProjectID(long managedProjectID){
        this.managedProjectID = managedProjectID;
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
