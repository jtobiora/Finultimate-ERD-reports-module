/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rsdynamix.projects.projectmgt.beans;

import com.rsdynamix.projects.projectmgt.entities.SoftwareAttributeEntity;
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
@ManagedBean(name = "softwareAttributeBean")
public class SoftwareAttributeBean {

    private  SoftwareAttributeEntity softwareAttribute;
    private  List<SoftwareAttributeEntity> softwareAttributeList;
    private  List<SelectItem> softwareAttributeItemList;

    public SoftwareAttributeBean() {
        softwareAttribute = new SoftwareAttributeEntity();
        softwareAttributeList = new ArrayList<SoftwareAttributeEntity>();
        softwareAttributeItemList = new ArrayList<SelectItem>();
    }

    public String addSoftwareAttribute() {
        return "";
    }

    public String saveSoftwareAttributeList() {
        return "";
    }

    public void softwareAttributeItemSelected(ValueChangeEvent vce) {
    }

    public void softwareAttributeSelected(ValueChangeEvent vce) {
        int rowIndex = CommonBean.getCheckBoxEventRowIndex(vce);
    }

    public SoftwareAttributeEntity getSoftwareAttribute() {
        return this.softwareAttribute;
    }

    public void setSoftwareAttribute(SoftwareAttributeEntity softwareAttribute) {
        this.softwareAttribute = softwareAttribute;
    }

    public List<SoftwareAttributeEntity> getSoftwareAttributeList() {
        return this.softwareAttributeList;
    }

    public void setSoftwareAttributeList(List<SoftwareAttributeEntity> softwareAttributeList) {
        this.softwareAttributeList = softwareAttributeList;
    }

    public List<SelectItem> getSoftwareAttributeItemList() {
        return this.softwareAttributeItemList;
    }

    public void setSoftwareAttributeItemList(List<SelectItem> softwareAttributeItemList) {
        this.softwareAttributeItemList = softwareAttributeItemList;
    }

}
