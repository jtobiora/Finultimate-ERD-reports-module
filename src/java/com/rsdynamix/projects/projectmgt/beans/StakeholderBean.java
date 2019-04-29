/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rsdynamix.projects.projectmgt.beans;

import com.rsdynamix.projects.projectmgt.entities.StakeholderEntity;
import com.rsdynamix.projects.web.commons.bean.CommonBean;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author p-aniah
 */

@ApplicationScoped
@ManagedBean(name = "stakeholderBean")
public class StakeholderBean {

    private  StakeholderEntity stakeholder;
    private  List<StakeholderEntity> stakeholderList;
    private  List<SelectItem> stakeholderItemList;

    public StakeholderBean() {
        stakeholder = new StakeholderEntity();
        stakeholderList = new ArrayList<StakeholderEntity>();
        stakeholderItemList = new ArrayList<SelectItem>();
    }

    public String addStakeholder() {
        return "";
    }

    public String saveStakeholderList() {
        return "";
    }

    public void stakeholderItemSelected(ValueChangeEvent vce) {
    }

    public void stakeholderSelected(ValueChangeEvent vce) {
        int rowIndex = CommonBean.getCheckBoxEventRowIndex(vce);
    }

    public StakeholderEntity getStakeholder() {
        return this.stakeholder;
    }

    public void setStakeholder(StakeholderEntity stakeholder) {
        this.stakeholder = stakeholder;
    }

    public List<StakeholderEntity> getStakeholderList() {
        return this.stakeholderList;
    }

    public void setStakeholderList(List<StakeholderEntity> stakeholderList) {
        this.stakeholderList = stakeholderList;
    }

    public List<SelectItem> getStakeholderItemList() {
        return this.stakeholderItemList;
    }

    public void setStakeholderItemList(List<SelectItem> stakeholderItemList) {
        this.stakeholderItemList = stakeholderItemList;
    }

}
