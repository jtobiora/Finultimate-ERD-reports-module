/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rsdynamix.projects.projectmgt.beans;

import com.rsdynamix.projects.projectmgt.entities.ManagedChangeRequestEntity;
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
@ManagedBean(name = "managedChangeRequestBean")
public class ManagedChangeRequestBean {

    private  ManagedChangeRequestEntity managedChangeRequest;
    private  List<ManagedChangeRequestEntity> managedChangeRequestList;
    private  List<SelectItem> managedChangeRequestItemList;

    public ManagedChangeRequestBean() {
        managedChangeRequest = new ManagedChangeRequestEntity();
        managedChangeRequestList = new ArrayList<ManagedChangeRequestEntity>();
        managedChangeRequestItemList = new ArrayList<SelectItem>();
    }

    public String addManagedChangeRequest() {
        return "";
    }

    public String saveManagedChangeRequestList() {
        return "";
    }

    public void managedChangeRequestItemSelected(ValueChangeEvent vce) {
    }

    public void managedChangeRequestSelected(ValueChangeEvent vce) {
        int rowIndex = CommonBean.getCheckBoxEventRowIndex(vce);
    }

    public ManagedChangeRequestEntity getManagedChangeRequest() {
        return this.managedChangeRequest;
    }

    public void setManagedChangeRequest(ManagedChangeRequestEntity managedChangeRequest) {
        this.managedChangeRequest = managedChangeRequest;
    }

    public List<ManagedChangeRequestEntity> getManagedChangeRequestList() {
        return this.managedChangeRequestList;
    }

    public void setManagedChangeRequestList(List<ManagedChangeRequestEntity> managedChangeRequestList) {
        this.managedChangeRequestList = managedChangeRequestList;
    }

    public List<SelectItem> getManagedChangeRequestItemList() {
        return this.managedChangeRequestItemList;
    }

    public void setManagedChangeRequestItemList(List<SelectItem> managedChangeRequestItemList) {
        this.managedChangeRequestItemList = managedChangeRequestItemList;
    }

}
