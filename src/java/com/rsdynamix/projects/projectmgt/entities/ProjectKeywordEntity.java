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
@Table(name = "PROJECT_KEYWORD")
public class ProjectKeywordEntity extends AbstractEntity implements Serializable{

    @Id
    @Column(name = "PROJECT_KEYWORD_ID", columnDefinition = "NUMBER(10)")
    private long projectKeywordID;
    //
    @Column(name = "PROJECT_KEYWORD", columnDefinition = "VARCHAR2(100)")
    private String projectKeyword;
    //
    @Column(name = "MANAGED_PROJECT_ID", columnDefinition = "NUMBER(10)")
    private long managedProjectID;
    //
    private transient String managedProjectName;
    //
    @Column(name = "APPROVAL_STATUS_ID", columnDefinition = "NUMBER(3)")
    private int approvalStatusID;
    //
    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(60)")
    private String approver = "";
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();

    public ProjectKeywordEntity () {
        projectKeywordID = 0;
        projectKeyword = "";
        managedProjectID = 0;
        managedProjectName = "";
    }
    
    public boolean equals(Object o) {
        return ((o instanceof ProjectKeywordEntity)
                && (((ProjectKeywordEntity)o).getProjectKeyword().equals(this.getProjectKeyword()))
                && (((ProjectKeywordEntity)o).getManagedProjectID() == this.getManagedProjectID()));
    }

    public long getProjectKeywordID(){
        return this.projectKeywordID;
    }

    public void setProjectKeywordID(long projectKeywordID){
        this.projectKeywordID = projectKeywordID;
    }

    public String getProjectKeyword(){
        return this.projectKeyword;
    }

    public void setProjectKeyword(String projectKeyword){
        this.projectKeyword = projectKeyword;
    }

    public long getManagedProjectID(){
        return this.managedProjectID;
    }

    public void setManagedProjectID(long managedProjectID){
        this.managedProjectID = managedProjectID;
    }

    public String getManagedProjectName(){
        return this.managedProjectName;
    }

    public void setManagedProjectName(String managedProjectName){
        this.managedProjectName = managedProjectName;
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
