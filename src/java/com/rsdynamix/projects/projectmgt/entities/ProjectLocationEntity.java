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
import java.math.BigDecimal;


/**
*
*     @author root
*/
@Entity
@Table(name = "PROJECT_LOCATION")
public class ProjectLocationEntity extends AbstractEntity implements Serializable{

    @Id
    @Column(name = "LOCATION_ID", columnDefinition = "NUMBER(10)")
    private int locationID;
    //
    @Column(name = "LOCATION_NAME", columnDefinition = "VARCHAR2(255)")
    private String locationName;
    //
    @Column(name = "CITY_ID", columnDefinition = "NUMBER(10)")
    private long cityID;
    //
    @Column(name = "STATE_CODE", columnDefinition = "VARCHAR2(3)")
    private String stateCode;
    //
    @Column(name = "COUNTRY_ID", columnDefinition = "NUMBER(10)")
    private long countryID;
    //
    private transient String countryName;
    //
    private transient String cityDesc;
    //
    private transient String stateName;
    //
    @Column(name = "APPROVAL_STATUS_ID", columnDefinition = "NUMBER(3)")
    private int approvalStatusID;
    //
    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(60)")
    private String approver = "";
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();

    public ProjectLocationEntity() {
        locationID = 0;
        locationName = "";
        cityID = 0;
        cityDesc = "";
        stateCode = "";
        stateName = "";
        countryID = 0;
        countryName = "";
    }
    
    public boolean equals(Object o) {
        return ((o instanceof ProjectLocationEntity) 
                && (((ProjectLocationEntity)o).getLocationName().equals(this.getLocationName()))
                && (((ProjectLocationEntity)o).getCountryID() == this.getCountryID())
                && (((ProjectLocationEntity)o).getStateCode().equals(this.getStateCode()))
                && (((ProjectLocationEntity)o).getCityID() == this.getCityID()));
    }

    public int getLocationID(){
        return this.locationID;
    }

    public void setLocationID(int locationID){
        this.locationID = locationID;
    }

    public String getLocationName(){
        return this.locationName;
    }

    public void setLocationName(String locationName){
        this.locationName = locationName;
    }

    public long getCityID(){
        return this.cityID;
    }

    public void setCityID(long cityID){
        this.cityID = cityID;
    }

    public String getCityDesc(){
        return this.cityDesc;
    }

    public void setCityDesc(String cityDesc){
        this.cityDesc = cityDesc;
    }

    public String getStateCode(){
        return this.stateCode;
    }

    public void setStateCode(String stateCode){
        this.stateCode = stateCode;
    }

    public String getStateName(){
        return this.stateName;
    }

    public void setStateName(String stateName){
        this.stateName = stateName;
    }

    public long getCountryID(){
        return this.countryID;
    }

    public void setCountryID(long countryID){
        this.countryID = countryID;
    }

    public String getCountryName(){
        return this.countryName;
    }

    public void setCountryName(String countryName){
        this.countryName = countryName;
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
