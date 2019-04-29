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
 * This class is a model for a data center rack for managing space, 
 * accessibility, and power resources for hardware
 *
 * @author p-aniah
 */
@Entity
@Table(name = "PROJECT_RACK")
public class ProjectRackEntity extends AbstractEntity implements Serializable{

    @Id
    @Column(name = "PROJECT_RACK_ID", columnDefinition = "NUMBER(10)")
    private long projectRackID;
    //
    @Column(name = "RACK_NUMBER", columnDefinition = "VARCHAR2(20)")
    private String rackNumber;
    //
    @Column(name = "DATA_CENTER_ID", columnDefinition = "NUMBER(10)")
    private int dataCenterID;
    //
    @Column(name = "APPROVAL_STATUS_ID", columnDefinition = "NUMBER(3)")
    private int approvalStatusID;
    //
    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(60)")
    private String approver = "";
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();

    public ProjectRackEntity() {
        projectRackID = 0;
        rackNumber = "";
        dataCenterID = 0;
    }
    
    public boolean equals(Object o) {
        return ((o instanceof ProjectRackEntity)
                && (((ProjectRackEntity)o).getRackNumber().equals(this.getRackNumber())));
    }

    public long getProjectRackID(){
        return this.projectRackID;
    }

    public void setProjectRackID(long projectRackID){
        this.projectRackID = projectRackID;
    }

    public String getRackNumber(){
        return this.rackNumber;
    }

    public void setRackNumber(String rackNumber){
        this.rackNumber = rackNumber;
    }

    public int getDataCenterID(){
        return this.dataCenterID;
    }

    public void setDataCenterID(int dataCenterID){
        this.dataCenterID = dataCenterID;
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
