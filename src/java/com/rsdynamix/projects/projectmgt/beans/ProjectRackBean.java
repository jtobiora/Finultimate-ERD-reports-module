/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rsdynamix.projects.projectmgt.beans;

import com.rsdynamix.projects.projectmgt.entities.ProjectRackEntity;
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
@ManagedBean(name = "projectRackBean")
public class ProjectRackBean {

    private  ProjectRackEntity projectRack;
    private  List<ProjectRackEntity> projectRackList;
    private  List<SelectItem> projectRackItemList;

    public ProjectRackBean() {
        projectRack = new ProjectRackEntity();
        projectRackList = new ArrayList<ProjectRackEntity>();
        projectRackItemList = new ArrayList<SelectItem>();
    }

    public String addProjectRack() {
        return "";
    }

    public String saveProjectRackList() {
        return "";
    }

    public void projectRackItemSelected(ValueChangeEvent vce) {
    }

    public void projectRackSelected(ValueChangeEvent vce) {
        int rowIndex = CommonBean.getCheckBoxEventRowIndex(vce);
    }

    public ProjectRackEntity getProjectRack() {
        return this.projectRack;
    }

    public void setProjectRack(ProjectRackEntity projectRack) {
        this.projectRack = projectRack;
    }

    public List<ProjectRackEntity> getProjectRackList() {
        return this.projectRackList;
    }

    public void setProjectRackList(List<ProjectRackEntity> projectRackList) {
        this.projectRackList = projectRackList;
    }

    public List<SelectItem> getProjectRackItemList() {
        return this.projectRackItemList;
    }

    public void setProjectRackItemList(List<SelectItem> projectRackItemList) {
        this.projectRackItemList = projectRackItemList;
    }

}

