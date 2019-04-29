/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import reporting.repository.PosItemRecordRepository;

/**
 *
 * @author S3-Developer
 */
@javax.faces.bean.SessionScoped
@ManagedBean(name = "posItemRecordBean")
public class PosItemRecordBean implements Serializable,PosItemRecordRepository {

    /**
     * Creates a new instance of PosItemRecordBean
     */
    public PosItemRecordBean() {
    }
    
}
