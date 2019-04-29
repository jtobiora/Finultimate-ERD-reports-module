/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rsdynamix.projects.projectmgt.beans;

import com.rsdynamix.projects.projectmgt.entities.ChangeRequestEntryEntity;
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
@ManagedBean(name = "changeRequestEntryBean")
public class ChangeRequestEntryBean {

    private  ChangeRequestEntryEntity changeRequestEntry;
    private  List<ChangeRequestEntryEntity> changeRequestEntryList;
    private  List<SelectItem> changeRequestEntryItemList;

    public ChangeRequestEntryBean() {
        changeRequestEntry = new ChangeRequestEntryEntity();
        changeRequestEntryList = new ArrayList<ChangeRequestEntryEntity>();
        changeRequestEntryItemList = new ArrayList<SelectItem>();
    }

    public String addChangeRequestEntry() {
        return "";
    }

    public String saveChangeRequestEntryList() {
        return "";
    }

    public void changeRequestEntryItemSelected(ValueChangeEvent vce) {
    }

    public void changeRequestEntrySelected(ValueChangeEvent vce) {
        int rowIndex = CommonBean.getCheckBoxEventRowIndex(vce);
    }

    public ChangeRequestEntryEntity getChangeRequestEntry() {
        return this.changeRequestEntry;
    }

    public void setChangeRequestEntry(ChangeRequestEntryEntity changeRequestEntry) {
        this.changeRequestEntry = changeRequestEntry;
    }

    public List<ChangeRequestEntryEntity> getChangeRequestEntryList() {
        return this.changeRequestEntryList;
    }

    public void setChangeRequestEntryList(List<ChangeRequestEntryEntity> changeRequestEntryList) {
        this.changeRequestEntryList = changeRequestEntryList;
    }

    public List<SelectItem> getChangeRequestEntryItemList() {
        return this.changeRequestEntryItemList;
    }

    public void setChangeRequestEntryItemList(List<SelectItem> changeRequestEntryItemList) {
        this.changeRequestEntryItemList = changeRequestEntryItemList;
    }

}

