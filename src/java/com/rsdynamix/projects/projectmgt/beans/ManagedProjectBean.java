/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rsdynamix.projects.projectmgt.beans;

import com.rsdynamix.projects.projectmgt.entities.ManagedProjectEntity;
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
@ManagedBean(name = "managedProjectBean")
public class ManagedProjectBean {

    private  ManagedProjectEntity managedProject;
    private  List<ManagedProjectEntity> managedProjectList;
    private  List<SelectItem> managedProjectItemList;

    public ManagedProjectBean() {
        managedProject = new ManagedProjectEntity();
        managedProjectList = new ArrayList<ManagedProjectEntity>();
        managedProjectItemList = new ArrayList<SelectItem>();
    }

    public String addManagedProject() {
        return "";
    }

    public String saveManagedProjectList() {
        return "";
    }

    public void managedProjectItemSelected(ValueChangeEvent vce) {
    }

    public void managedProjectSelected(ValueChangeEvent vce) {
        int rowIndex = CommonBean.getCheckBoxEventRowIndex(vce);
    }

    public ManagedProjectEntity getManagedProject() {
        return this.managedProject;
    }

    public void setManagedProject(ManagedProjectEntity managedProject) {
        this.managedProject = managedProject;
    }

    public List<ManagedProjectEntity> getManagedProjectList() {
        return this.managedProjectList;
    }

    public void setManagedProjectList(List<ManagedProjectEntity> managedProjectList) {
        this.managedProjectList = managedProjectList;
    }

    public List<SelectItem> getManagedProjectItemList() {
        return this.managedProjectItemList;
    }

    public void setManagedProjectItemList(List<SelectItem> managedProjectItemList) {
        this.managedProjectItemList = managedProjectItemList;
    }

}

