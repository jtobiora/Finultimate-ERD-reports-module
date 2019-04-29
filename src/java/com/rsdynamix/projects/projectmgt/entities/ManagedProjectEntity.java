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
@Table(name = "MANAGED_PROJECT")
public class ManagedProjectEntity extends AbstractEntity implements Serializable{

    @Id
    @Column(name = "MANAGED_PROJECT_ID", columnDefinition = "NUMBER(10)")
    private long managedProjectID;
    //
    @Column(name = "PROJECT_TITLE", columnDefinition = "VARCHAR2(100)")
    private String projectTitle;
    //
    private transient List<ProjectKeywordEntity> keywordList;
    //
    private transient List<ManagedHardwareEntity> hardwareComponentList;
    //
    private transient List<ManagedSoftwareEntity> softwareComponentList;
    //
    private transient List<ProjectAttributeEntity> attributeList;
    //
    @Column(name = "APPROVAL_STATUS_ID", columnDefinition = "NUMBER(3)")
    private int approvalStatusID;
    //
    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(60)")
    private String approver = "";
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();

    public ManagedProjectEntity () {
        managedProjectID = 0;
        projectTitle = "";
        //
        keywordList = new ArrayList<ProjectKeywordEntity>();
        hardwareComponentList = new ArrayList<ManagedHardwareEntity>();
        softwareComponentList = new ArrayList<ManagedSoftwareEntity>();
        attributeList = new ArrayList<ProjectAttributeEntity>();
    }
    
    public boolean equals(Object o) {
        return ((o instanceof ManagedProjectEntity)
                && (((ManagedProjectEntity)o).getProjectTitle().equals(this.getProjectTitle())));
    }

    public long getManagedProjectID(){
        return this.managedProjectID;
    }

    public void setManagedProjectID(long managedProjectID){
        this.managedProjectID = managedProjectID;
    }

    public String getProjectTitle(){
        return this.projectTitle;
    }

    public void setProjectTitle(String projectTitle){
        this.projectTitle = projectTitle;
    }

    /**
     * @return the keywordList
     */
    public List<ProjectKeywordEntity> getKeywordList() {
        return keywordList;
    }

    /**
     * @param keywordList the keywordList to set
     */
    public void setKeywordList(List<ProjectKeywordEntity> keywordList) {
        this.keywordList = keywordList;
    }

    /**
     * @return the hardwareComponentList
     */
    public List<ManagedHardwareEntity> getHardwareComponentList() {
        return hardwareComponentList;
    }

    /**
     * @param hardwareComponentList the hardwareComponentList to set
     */
    public void setHardwareComponentList(List<ManagedHardwareEntity> hardwareComponentList) {
        this.hardwareComponentList = hardwareComponentList;
    }

    /**
     * @return the softwareComponentList
     */
    public List<ManagedSoftwareEntity> getSoftwareComponentList() {
        return softwareComponentList;
    }

    /**
     * @param softwareComponentList the softwareComponentList to set
     */
    public void setSoftwareComponentList(List<ManagedSoftwareEntity> softwareComponentList) {
        this.softwareComponentList = softwareComponentList;
    }

    /**
     * @return the attributeList
     */
    public List<ProjectAttributeEntity> getAttributeList() {
        return attributeList;
    }

    /**
     * @param attributeList the attributeList to set
     */
    public void setAttributeList(List<ProjectAttributeEntity> attributeList) {
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
