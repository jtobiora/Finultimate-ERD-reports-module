/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rsdynamix.projects.projectmgt.beans;

import com.rsdynamix.projects.projectmgt.entities.ProcessorTypeEntity;
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
@ManagedBean(name = "processorTypeBean")
public class ProcessorTypeBean {

    private  ProcessorTypeEntity processorType;
    private  List<ProcessorTypeEntity> processorTypeList;
    private  List<SelectItem> processorTypeItemList;

    public ProcessorTypeBean() {
        processorType = new ProcessorTypeEntity();
        processorTypeList = new ArrayList<ProcessorTypeEntity>();
        processorTypeItemList = new ArrayList<SelectItem>();
    }

    public String addProcessorType() {
        return "";
    }

    public String saveProcessorTypeList() {
        return "";
    }

    public void processorTypeItemSelected(ValueChangeEvent vce) {
    }

    public void processorTypeSelected(ValueChangeEvent vce) {
        int rowIndex = CommonBean.getCheckBoxEventRowIndex(vce);
    }
    
    public void processorTypeMenuSelected(ValueChangeEvent vce) {
        
    }

    public ProcessorTypeEntity getProcessorType() {
        return this.processorType;
    }

    public void setProcessorType(ProcessorTypeEntity processorType) {
        this.processorType = processorType;
    }

    public List<ProcessorTypeEntity> getProcessorTypeList() {
        return this.processorTypeList;
    }

    public void setProcessorTypeList(List<ProcessorTypeEntity> processorTypeList) {
        this.processorTypeList = processorTypeList;
    }

    public List<SelectItem> getProcessorTypeItemList() {
        return this.processorTypeItemList;
    }

    public void setProcessorTypeItemList(List<SelectItem> processorTypeItemList) {
        this.processorTypeItemList = processorTypeItemList;
    }

}
