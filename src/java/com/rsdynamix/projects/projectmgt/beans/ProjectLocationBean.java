/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rsdynamix.projects.projectmgt.beans;

import com.rsdynamix.projects.projectmgt.entities.ProjectLocationEntity;
import com.rsdynamix.projects.web.commons.bean.CommonBean;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

/**
*
* 	@author patushie@codrellica
*/

@ApplicationScoped
@ManagedBean(name = "projectLocationBean")
public class ProjectLocationBean {

    private  ProjectLocationEntity projectLocation;
    private  List<ProjectLocationEntity> projectLocationList;
    private  List<SelectItem> projectLocationItemList;

    public ProjectLocationBean() {
        projectLocation = new ProjectLocationEntity();
        projectLocationList = new ArrayList<ProjectLocationEntity>();
        projectLocationItemList = new ArrayList<SelectItem>();
    }

    public String addProjectLocation() {
        return "";
    }

    public String saveProjectLocationList() {
        return "";
    }

    public void projectLocationItemSelected(ValueChangeEvent vce) {
    }

    public void projectLocationSelected(ValueChangeEvent vce) {
        int rowIndex = CommonBean.getCheckBoxEventRowIndex(vce);
    }

    public ProjectLocationEntity getProjectLocation() {
        return this.projectLocation;
    }

    public void setProjectLocation(ProjectLocationEntity projectLocation) {
        this.projectLocation = projectLocation;
    }

    public List<ProjectLocationEntity> getProjectLocationList() {
        return this.projectLocationList;
    }

    public void setProjectLocationList(List<ProjectLocationEntity> projectLocationList) {
        this.projectLocationList = projectLocationList;
    }

    public List<SelectItem> getProjectLocationItemList() {
        return this.projectLocationItemList;
    }

    public void setProjectLocationItemList(List<SelectItem> projectLocationItemList) {
        this.projectLocationItemList = projectLocationItemList;
    }

}
