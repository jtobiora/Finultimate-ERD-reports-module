/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rsdynamix.projects.projectmgt.beans;

import com.rsdynamix.projects.projectmgt.entities.PriorityTypeEntity;
import com.rsdynamix.projects.web.commons.bean.CommonBean;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

/**
*
* 	@author patushie@codrellica
*/

@ApplicationScoped
@ManagedBean(name = "priorityTypeBean")
public class PriorityTypeBean {

    private  PriorityTypeEntity priorityType;
    private  List<PriorityTypeEntity> priorityTypeList;
    private  List<SelectItem> priorityTypeItemList;

    public PriorityTypeBean() {
        priorityType = new PriorityTypeEntity();
        priorityTypeList = new ArrayList<PriorityTypeEntity>();
        priorityTypeItemList = new ArrayList<SelectItem>();
    }

    public String addPriorityType() {
        return "";
    }

    public String savePriorityTypeList() {
        return "";
    }

    public void priorityTypeItemSelected(ValueChangeEvent vce) {
    }

    public void priorityTypeSelected(ValueChangeEvent vce) {
        int rowIndex = CommonBean.getCheckBoxEventRowIndex(vce);
    }

    public PriorityTypeEntity getPriorityType() {
        return this.priorityType;
    }

    public void setPriorityType(PriorityTypeEntity priorityType) {
        this.priorityType = priorityType;
    }

    public List<PriorityTypeEntity> getPriorityTypeList() {
        return this.priorityTypeList;
    }

    public void setPriorityTypeList(List<PriorityTypeEntity> priorityTypeList) {
        this.priorityTypeList = priorityTypeList;
    }

    public List<SelectItem> getPriorityTypeItemList() {
        return this.priorityTypeItemList;
    }

    public void setPriorityTypeItemList(List<SelectItem> priorityTypeItemList) {
        this.priorityTypeItemList = priorityTypeItemList;
    }

}
