/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rsdynamix.projects.projectmgt.beans;

import com.rsdynamix.projects.projectmgt.entities.ProjectAttributeEntity;
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
@ManagedBean(name = "projectAttributeBean")
public class ProjectAttributeBean {

    private  ProjectAttributeEntity projectAttribute;
    private  List<ProjectAttributeEntity> projectAttributeList;
    private  List<SelectItem> projectAttributeItemList;

    public ProjectAttributeBean() {
        projectAttribute = new ProjectAttributeEntity();
        projectAttributeList = new ArrayList<ProjectAttributeEntity>();
        projectAttributeItemList = new ArrayList<SelectItem>();
    }

    public String addProjectAttribute() {
        return "";
    }

    public String saveProjectAttributeList() {
        return "";
    }

    public void projectAttributeItemSelected(ValueChangeEvent vce) {
    }

    public void projectAttributeSelected(ValueChangeEvent vce) {
        int rowIndex = CommonBean.getCheckBoxEventRowIndex(vce);
    }

    public ProjectAttributeEntity getProjectAttribute() {
        return this.projectAttribute;
    }

    public void setProjectAttribute(ProjectAttributeEntity projectAttribute) {
        this.projectAttribute = projectAttribute;
    }

    public List<ProjectAttributeEntity> getProjectAttributeList() {
        return this.projectAttributeList;
    }

    public void setProjectAttributeList(List<ProjectAttributeEntity> projectAttributeList) {
        this.projectAttributeList = projectAttributeList;
    }

    public List<SelectItem> getProjectAttributeItemList() {
        return this.projectAttributeItemList;
    }

    public void setProjectAttributeItemList(List<SelectItem> projectAttributeItemList) {
        this.projectAttributeItemList = projectAttributeItemList;
    }

}

