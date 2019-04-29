/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsdynamix.projects.projectmgt.beans;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author p-aniah
 */

@ViewScoped
@ManagedBean(name = "scheduleBean")
public class ScheduleBean implements Serializable {

    private ScheduleModel model;

    public ScheduleBean() {
        model = new DefaultScheduleModel();
        model.addEvent(new DefaultScheduleEvent("Annuity Settlement", new Date(), new Date()));
    }

    public ScheduleModel getModel() {
        return model;
    }

}
