/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rsdynamix.projects.projectmgt.beans;

/**
 *
 * @author p-aniah
 */



import com.rsdynamix.projects.projectmgt.entities.StakeholderTypeEntity;
import com.rsdynamix.projects.web.commons.bean.CommonBean;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

/**
*
* @author patushie@codrellica
*/
@ApplicationScoped
@ManagedBean(name = "stakeholderTypeBean")
public class StakeholderTypeBean {

    private  StakeholderTypeEntity stakeholderType;
    private  List<StakeholderTypeEntity> stakeholderTypeList;
    private  List<SelectItem> stakeholderTypeItemList;

    public StakeholderTypeBean() {
        stakeholderType = new StakeholderTypeEntity();
        stakeholderTypeList = new ArrayList<StakeholderTypeEntity>();
        stakeholderTypeItemList = new ArrayList<SelectItem>();
    }
    
    public String loadStakeholderType() {
        return "";
    }

    public String addStakeholderType() {
        return "";
    }

    public String saveStakeholderTypeList() {
        return "";
    }

    public void stakeholderTypeItemSelected(ValueChangeEvent vce) {
    }

    public void stakeholderTypeSelected(ValueChangeEvent vce) {
        int rowIndex = CommonBean.getCheckBoxEventRowIndex(vce);
    }

    public StakeholderTypeEntity getStakeholderType() {
        return this.stakeholderType;
    }

    public void setStakeholderType(StakeholderTypeEntity stakeholderType) {
        this.stakeholderType = stakeholderType;
    }

    public List<StakeholderTypeEntity> getStakeholderTypeList() {
        return this.stakeholderTypeList;
    }

    public void setStakeholderTypeList(List<StakeholderTypeEntity> stakeholderTypeList) {
        this.stakeholderTypeList = stakeholderTypeList;
    }

    public List<SelectItem> getStakeholderTypeItemList() {
        return this.stakeholderTypeItemList;
    }

    public void setStakeholderTypeItemList(List<SelectItem> stakeholderTypeItemList) {
        this.stakeholderTypeItemList = stakeholderTypeItemList;
    }

}

