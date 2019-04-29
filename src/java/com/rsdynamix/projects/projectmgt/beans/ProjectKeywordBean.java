/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rsdynamix.projects.projectmgt.beans;

import com.rsdynamix.projects.projectmgt.entities.ProjectKeywordEntity;
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
@ManagedBean(name = "projectKeywordBean")
public class ProjectKeywordBean {

    private  ProjectKeywordEntity projectKeyword;
    private  List<ProjectKeywordEntity> projectKeywordList;
    private  List<SelectItem> projectKeywordItemList;

    public ProjectKeywordBean() {
        projectKeyword = new ProjectKeywordEntity();
        projectKeywordList = new ArrayList<ProjectKeywordEntity>();
        projectKeywordItemList = new ArrayList<SelectItem>();
    }

    public String addProjectKeywordEntity() {
        return "";
    }

    public String saveProjectKeywordEntityList() {
        return "";
    }

    public void projectKeywordItemSelected(ValueChangeEvent vce) {
    }

    public void projectKeywordSelected(ValueChangeEvent vce) {
        int rowIndex = CommonBean.getCheckBoxEventRowIndex(vce);
    }

    public ProjectKeywordEntity getProjectKeywordEntity() {
        return this.projectKeyword;
    }

    public void setProjectKeywordEntity(ProjectKeywordEntity projectKeyword) {
        this.projectKeyword = projectKeyword;
    }

    public List<ProjectKeywordEntity> getProjectKeywordEntityList() {
        return this.projectKeywordList;
    }

    public void setProjectKeywordEntityList(List<ProjectKeywordEntity> projectKeywordList) {
        this.projectKeywordList = projectKeywordList;
    }

    public List<SelectItem> getProjectKeywordEntityItemList() {
        return this.projectKeywordItemList;
    }

    public void setProjectKeywordEntityItemList(List<SelectItem> projectKeywordItemList) {
        this.projectKeywordItemList = projectKeywordItemList;
    }

}
