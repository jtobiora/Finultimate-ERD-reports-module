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
@Table(name = "PROJECT_UNIT")
public class ProjectUnitEntity extends AbstractEntity implements Serializable{

    @Id
    @Column(name = "PROJECT_UNIT_ID", columnDefinition = "NUMBER(10)")
    private int projectUnitID;
    //
    @Column(name = "PROJECT_UNIT_NAME", columnDefinition = "VARCHAR2(100)")
    private String projectUnitName;
    //
    @Column(name = "DEPARTMENT_ID", columnDefinition = "NUMBER(10)")
    private int departmentID;
    //
    private transient String departmentName;
    //
    @Column(name = "APPROVAL_STATUS_ID", columnDefinition = "NUMBER(3)")
    private int approvalStatusID;
    //
    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(60)")
    private String approver = "";
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();

    public ProjectUnitEntity() {
        projectUnitID = 0;
        projectUnitName = "";
        departmentID = 0;
        departmentName = "";
    }
    
    public boolean equals(Object o) {
        return ((o instanceof ProjectUnitEntity) 
                && (((ProjectUnitEntity)o).getProjectUnitName().equals(this.getProjectUnitName()))
                && (((ProjectUnitEntity)o).getDepartmentID() == this.getDepartmentID()));
    }

    public int getProjectUnitID(){
        return this.projectUnitID;
    }

    public void setProjectUnitID(int projectUnitID){
        this.projectUnitID = projectUnitID;
    }

    public String getProjectUnitName(){
        return this.projectUnitName;
    }

    public void setProjectUnitName(String projectUnitName){
        this.projectUnitName = projectUnitName;
    }

    public int getDepartmentID(){
        return this.departmentID;
    }

    public void setDepartmentID(int departmentID){
        this.departmentID = departmentID;
    }

    /**
     * @return the departmentName
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * @param departmentName the departmentName to set
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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

