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
import java.io.Serializable;
import com.rsdynamix.abstractobjects.AbstractEntity;
import com.rsdynamix.dynamo.common.entities.BusinessActionTrailEntity;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name = "STAKEHOLDER")
public class StakeholderEntity extends AbstractEntity implements Serializable{

    @Id
    @Column(name = "STAKEHOLDER_ID", columnDefinition = "NUMBER(10)")
    private long stakeholderID;
    //
    @Column(name = "STAKEHOLDER_NAME", columnDefinition = "VARCHAR2(100)")
    private String stakeholderName;
    //
    @Column(name = "STAKEHOLDER_TYPE_ID", columnDefinition = "NUMBER(2)")
    private int stakeholderTypeID;
    //
    @Column(name = "COMPANY_ID", columnDefinition = "NUMBER(10)")
    private int companyID;
    //
    @Column(name = "DEPARTMENT_ID", columnDefinition = "NUMBER(10)")
    private int departmentID;
    //
    @Column(name = "ROLE_ID", columnDefinition = "NUMBER(10)")
    private int roleID;
    //
    private transient String roleDesc;
    //
    private transient String stakeholderTypeDesc;
    //
    private transient String companyName;
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


    public StakeholderEntity() {
        stakeholderID = 0;
        stakeholderName = "";
        stakeholderTypeID = 0;
        companyID = 0;
        departmentID = 0;
        roleID = 0;
        roleDesc = "";
        stakeholderTypeDesc = "";
        companyName = "";
        departmentName = "";
    }

    public long getStakeholderID(){
        return this.stakeholderID;
    }

    public void setStakeholderID(long stakeholderID){
        this.stakeholderID = stakeholderID;
    }

    public String getStakeholderName(){
        return this.stakeholderName;
    }

    public void setStakeholderName(String stakeholderName){
        this.stakeholderName = stakeholderName;
    }

    public int getStakeholderTypeID(){
        return this.stakeholderTypeID;
    }

    public void setStakeholderTypeID(int stakeholderTypeID){
        this.stakeholderTypeID = stakeholderTypeID;
    }

    public int getCompanyID(){
        return this.companyID;
    }

    public void setCompanyID(int companyID){
        this.companyID = companyID;
    }

    public int getDepartmentID(){
        return this.departmentID;
    }

    public void setDepartmentID(int departmentID){
        this.departmentID = departmentID;
    }

    public int getRoleID(){
        return this.roleID;
    }

    public void setRoleID(int roleID){
        this.roleID = roleID;
    }

    public String getRoleDesc(){
        return this.roleDesc;
    }

    public void setRoleDesc(String roleDesc){
        this.roleDesc = roleDesc;
    }

    public String getStakeholderTypeDesc(){
        return this.stakeholderTypeDesc;
    }

    public void setStakeholderTypeDesc(String stakeholderTypeDesc){
        this.stakeholderTypeDesc = stakeholderTypeDesc;
    }

    public String getCompanyName(){
        return this.companyName;
    }

    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }

    public String getDepartmentName(){
        return this.departmentName;
    }

    public void setDepartmentName(String departmentName){
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

