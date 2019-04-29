/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rsdynamix.projects.projectmgt.beans;

import com.rsdynamix.projects.projectmgt.entities.ManagedHardwareEntity;
import com.rsdynamix.projects.web.commons.bean.CommonBean;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

/**
*
* 	@author patushie@codrellica
*/

@SessionScoped
@ManagedBean(name = "managedHardwareBean")
public class ManagedHardwareBean {

    private  ManagedHardwareEntity managedHardware;
    private  List<ManagedHardwareEntity> managedHardwareList;
    private  List<SelectItem> managedHardwareItemList;

    public ManagedHardwareBean() {
        managedHardware = new ManagedHardwareEntity();
        managedHardwareList = new ArrayList<ManagedHardwareEntity>();
        managedHardwareItemList = new ArrayList<SelectItem>();
    }

    public String addManagedHardware() {
        return "";
    }

    public String saveManagedHardwareList() {
        return "";
    }

    public void managedHardwareItemSelected(ValueChangeEvent vce) {
    }

    public void managedHardwareSelected(ValueChangeEvent vce) {
        int rowIndex = CommonBean.getCheckBoxEventRowIndex(vce);
    }

    public ManagedHardwareEntity getManagedHardware() {
        return this.managedHardware;
    }

    public void setManagedHardware(ManagedHardwareEntity managedHardware) {
        this.managedHardware = managedHardware;
    }

    public List<ManagedHardwareEntity> getManagedHardwareList() {
        return this.managedHardwareList;
    }

    public void setManagedHardwareList(List<ManagedHardwareEntity> managedHardwareList) {
        this.managedHardwareList = managedHardwareList;
    }

    public List<SelectItem> getManagedHardwareItemList() {
        return this.managedHardwareItemList;
    }

    public void setManagedHardwareItemList(List<SelectItem> managedHardwareItemList) {
        this.managedHardwareItemList = managedHardwareItemList;
    }

}
