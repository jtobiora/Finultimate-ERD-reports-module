/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rsdynamix.projects.projectmgt.entities;

import com.rsdynamix.abstractobjects.AbstractEntity;
import com.rsdynamix.dynamo.common.entities.BusinessActionTrailEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author p-aniah
 */
@Entity
@Table(name = "PROCESSOR_TYPE")
public class ProcessorTypeEntity extends AbstractEntity implements Serializable {
    
    @Id
    @Column(name = "PROCESSOR_TYPE_ID", columnDefinition = "NUMBER(10)")
    private long processorTypeID;
    //
    @Column(name = "PROCESSOR_NAME", columnDefinition = "VARCHAR2(100)")
    private String processorName;
    //
    @Column(name = "MANUFACTURER_ID", columnDefinition = "NUMBER(10)")
    private long manufacturerID;
    //
    @Column(name = "PROCESSOR_SPEED_GHZ", columnDefinition = "DOUBLE PRECISION")
    private BigDecimal processorSpeedGHZ;
    //
    private transient String manufacturerName;
    //
    @Column(name = "APPROVAL_STATUS_ID", columnDefinition = "NUMBER(3)")
    private int approvalStatusID;
    //
    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(60)")
    private String approver = "";
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();

    public ProcessorTypeEntity () {
        processorTypeID = 0;
        processorName = "";
        manufacturerID = 0;
        processorSpeedGHZ = BigDecimal.ZERO;
        manufacturerName = "";
    }
    
    public boolean equals(Object o) {
        return ((o instanceof ProcessorTypeEntity) 
                && (((ProcessorTypeEntity)o).getProcessorName().equals(this.getProcessorName())));
    }

    /**
     * @return the processorTypeID
     */
    public long getProcessorTypeID() {
        return processorTypeID;
    }

    /**
     * @param processorTypeID the processorTypeID to set
     */
    public void setProcessorTypeID(long processorTypeID) {
        this.processorTypeID = processorTypeID;
    }

    /**
     * @return the processorName
     */
    public String getProcessorName() {
        return processorName;
    }

    /**
     * @param processorName the processorName to set
     */
    public void setProcessorName(String processorName) {
        this.processorName = processorName;
    }

    /**
     * @return the manufacturerID
     */
    public long getManufacturerID() {
        return manufacturerID;
    }

    /**
     * @param manufacturerID the manufacturerID to set
     */
    public void setManufacturerID(long manufacturerID) {
        this.manufacturerID = manufacturerID;
    }

    /**
     * @return the processorSpeedGH
     */
    public BigDecimal getProcessorSpeedGHZ() {
        return processorSpeedGHZ;
    }

    /**
     * @param processorSpeedGH the processorSpeedGH to set
     */
    public void setProcessorSpeedGHZ(BigDecimal processorSpeedGHZ) {
        this.processorSpeedGHZ = processorSpeedGHZ;
    }

    /**
     * @return the manufacturerName
     */
    public String getManufacturerName() {
        return manufacturerName;
    }

    /**
     * @param manufacturerName the manufacturerName to set
     */
    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
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
