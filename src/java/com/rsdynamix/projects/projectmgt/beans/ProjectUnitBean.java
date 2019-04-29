/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rsdynamix.projects.projectmgt.beans;

import com.rsdynamix.projects.projectmgt.entities.ProjectUnitEntity;
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
@ManagedBean(name = "projectUnitBean")
public class ProjectUnitBean {

    private  ProjectUnitEntity projectUnit;
    private  List<ProjectUnitEntity> projectUnitList;
    private  List<SelectItem> projectUnitItemList;

    public ProjectUnitBean() {
        projectUnit = new ProjectUnitEntity();
        projectUnitList = new ArrayList<ProjectUnitEntity>();
        projectUnitItemList = new ArrayList<SelectItem>();
    }

    public String addProjectUnit() {
        return "";
    }

    public String saveProjectUnitList() {
        return "";
    }

    public void projectUnitItemSelected(ValueChangeEvent vce) {
    }

    public void projectUnitSelected(ValueChangeEvent vce) {
        int rowIndex = CommonBean.getCheckBoxEventRowIndex(vce);
    }

    public ProjectUnitEntity getProjectUnit() {
        return this.projectUnit;
    }

    public void setProjectUnit(ProjectUnitEntity projectUnit) {
        this.projectUnit = projectUnit;
    }

    public List<ProjectUnitEntity> getProjectUnitList() {
        return this.projectUnitList;
    }

    public void setProjectUnitList(List<ProjectUnitEntity> projectUnitList) {
        this.projectUnitList = projectUnitList;
    }

    public List<SelectItem> getProjectUnitItemList() {
        return this.projectUnitItemList;
    }

    public void setProjectUnitItemList(List<SelectItem> projectUnitItemList) {
        this.projectUnitItemList = projectUnitItemList;
    }

}

