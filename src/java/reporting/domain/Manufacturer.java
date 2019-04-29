/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting.domain;

import com.rsdynamics.projects.query.operators.EntityOperatorHolder;
import com.rsdynamix.abstractobjects.AbstractEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author S3-Developer
 */
@Entity
@Table(name = "MANUFACTURER")
public class Manufacturer extends AbstractEntity implements Serializable {

    @Id
    @Column(name = "MANUFACTURER_ID", columnDefinition = "NUMBER(11)")
    private int manufacturer_id;

    @Column(name = "MANUFACTURER_NAME", columnDefinition = "Varchar2(100)")
    private String manufacturer_name;

    @Column(name = "COUNTRY_ID", columnDefinition = "NUMBER(11)")
    private int country_id;

    @Column(name = "APPROVAL_STATUS_ID", columnDefinition = "NUMBER(11)")
    private int approval_status_id;

    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(60)")
    private String approver;

    public Manufacturer(){
    
    }

    public int getManufacturer_id() {
        return manufacturer_id;
    }

    public void setManufacturer_id(int manufacturer_id) {
        this.manufacturer_id = manufacturer_id;
    }

    public String getManufacturer_name() {
        return manufacturer_name;
    }

    public void setManufacturer_name(String manufacturer_name) {
        this.manufacturer_name = manufacturer_name;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public int getApproval_status_id() {
        return approval_status_id;
    }

    public void setApproval_status_id(int approval_status_id) {
        this.approval_status_id = approval_status_id;
    }

    public EntityOperatorHolder getOperatorHolder() {
        return operatorHolder;
    }

    public void setOperatorHolder(EntityOperatorHolder operatorHolder) {
        this.operatorHolder = operatorHolder;
    }

    
    
    
    @Override
    public void setApprover(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "manufacturer_name=" + manufacturer_name;
    }
    
    

}
