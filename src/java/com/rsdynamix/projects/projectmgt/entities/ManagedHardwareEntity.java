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
import java.sql.Date;


/**
*
*     @author patushie
*/
@Entity
@Table(name = "MANAGED_HARDWARE")
public class ManagedHardwareEntity extends AbstractEntity implements Serializable{

    @Id
    @Column(name = "HARDWARE_ID", columnDefinition = "NUMBER(10)")
    private long hardwareID;
    //
    @Column(name = "HARDWARE_NAME", columnDefinition = "VARCHAR2(100)")
    private String hardwareName;
    //
    @Column(name = "HARDWARE_LOC_CODE", columnDefinition = "VARCHAR2(20)")
    private String hardwareCode;
    //
    @Column(name = "PROJECT_RACK_ID", columnDefinition = "NUMBER(10)")
    private long projectRackID;
    //
    @Column(name = "MANUFACTURER_ID", columnDefinition = "NUMBER(10)")
    private long manufacturerID;
    //
    @Column(name = "MODEL_NUMBER", columnDefinition = "VARCHAR2(30)")
    private String modelNumber;
    //
    @Column(name = "PROCESSOR_TYPE_ID", columnDefinition = "NUMBER(10)")
    private int processorTypeID;
    //
    @Column(name = "RAM_SIZE", columnDefinition = "NUMBER(10)")
    private int ramSize;
    //
    @Column(name = "MANUFACTURE_DATE", columnDefinition = "DATE")
    private Date manufactureDate;
    //
    @Column(name = "HARD_DISK_SPACE", columnDefinition = "NUMBER(10)")
    private int hardDiskSpace;
    //
    private transient String rackNumber;
    //
    private transient String manufacturerName;
    //
    private transient String processorTypeDesc;
    //
    @Column(name = "APPROVAL_STATUS_ID", columnDefinition = "NUMBER(3)")
    private int approvalStatusID;
    //
    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(60)")
    private String approver = "";
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();

    public ManagedHardwareEntity() {
        hardwareID = 0;
        hardwareName = "";
        hardwareCode = "";
        projectRackID = 0;
        rackNumber = "";
        manufacturerID = 0;
        manufacturerName = "";
        modelNumber = "";
        processorTypeID = 0;
        processorTypeDesc = "";
        ramSize = 0;
        hardDiskSpace = 0;
    }
    
    public boolean equals(Object o) {
        return ((o instanceof ManagedHardwareEntity) 
                && (((ManagedHardwareEntity)o).getHardwareName().equals(this.getHardwareName()))
                && (((ManagedHardwareEntity)o).getModelNumber().equals(this.getModelNumber()))
                && (((ManagedHardwareEntity)o).getProjectRackID() == this.getProjectRackID()));
    }

    public long getHardwareID(){
        return this.hardwareID;
    }

    public void setHardwareID(long hardwareID){
        this.hardwareID = hardwareID;
    }

    public String getHardwareName(){
        return this.hardwareName;
    }

    public void setHardwareName(String hardwareName){
        this.hardwareName = hardwareName;
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

    public long getManufacturerID(){
        return this.manufacturerID;
    }

    public void setManufacturerID(long manufacturerID){
        this.manufacturerID = manufacturerID;
    }

    public String getManufacturerName(){
        return this.manufacturerName;
    }

    public void setManufacturerName(String manufacturerName){
        this.manufacturerName = manufacturerName;
    }

    public String getModelNumber(){
        return this.modelNumber;
    }

    public void setModelNumber(String modelNumber){
        this.modelNumber = modelNumber;
    }

    public int getProcessorTypeID(){
        return this.processorTypeID;
    }

    public void setProcessorTypeID(int processorTypeID){
        this.processorTypeID = processorTypeID;
    }

    public String getProcessorTypeDesc(){
        return this.processorTypeDesc;
    }

    public void setProcessorTypeDesc(String processorTypeDesc){
        this.processorTypeDesc = processorTypeDesc;
    }

    public int getRamSize(){
        return this.ramSize;
    }

    public void setRamSize(int ramSize){
        this.ramSize = ramSize;
    }

    public Date getManufactureDate(){
        return this.manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate){
        this.manufactureDate = manufactureDate;
    }

    public int getHardDiskSpace(){
        return this.hardDiskSpace;
    }

    public void setHardDiskSpace(int hardDiskSpace){
        this.hardDiskSpace = hardDiskSpace;
    }

    /**
     * @return the hardwareCode
     */
    public String getHardwareCode() {
        return hardwareCode;
    }

    /**
     * @param hardwareCode the hardwareCode to set
     */
    public void setHardwareCode(String hardwareCode) {
        this.hardwareCode = hardwareCode;
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
