/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rsdynamix.projects.projectmgt.beans;

import com.rsdynamix.projects.projectmgt.entities.ManagedSoftwareEntity;
import com.rsdynamix.projects.web.commons.bean.CommonBean;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

/**
*
* 	@author patushie@codrellica
*/

@SessionScoped
@ManagedBean(name = "managedSoftwareBean")
public class ManagedSoftwareBean {

    private  ManagedSoftwareEntity managedSoftware;
    private  List<ManagedSoftwareEntity> managedSoftwareList;
    private  List<SelectItem> managedSoftwareItemList;

    public ManagedSoftwareBean() {
        managedSoftware = new ManagedSoftwareEntity();
        managedSoftwareList = new ArrayList<ManagedSoftwareEntity>();
        managedSoftwareItemList = new ArrayList<SelectItem>();
    }

    public String addManagedSoftware() {
        return "";
    }

    public String saveManagedSoftwareList() {
        return "";
    }

    public void managedSoftwareItemSelected(ValueChangeEvent vce) {
    }

    public void managedSoftwareSelected(ValueChangeEvent vce) {
        int rowIndex = CommonBean.getCheckBoxEventRowIndex(vce);
    }

    public ManagedSoftwareEntity getManagedSoftware() {
        return this.managedSoftware;
    }

    public void setManagedSoftware(ManagedSoftwareEntity managedSoftware) {
        this.managedSoftware = managedSoftware;
    }

    public List<ManagedSoftwareEntity> getManagedSoftwareList() {
        return this.managedSoftwareList;
    }

    public void setManagedSoftwareList(List<ManagedSoftwareEntity> managedSoftwareList) {
        this.managedSoftwareList = managedSoftwareList;
    }

    public List<SelectItem> getManagedSoftwareItemList() {
        return this.managedSoftwareItemList;
    }

    public void setManagedSoftwareItemList(List<SelectItem> managedSoftwareItemList) {
        this.managedSoftwareItemList = managedSoftwareItemList;
    }

}
