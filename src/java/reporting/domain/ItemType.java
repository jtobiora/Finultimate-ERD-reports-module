/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting.domain;

import com.rsdynamix.abstractobjects.AbstractEntity;
import com.rsdynamix.dynamo.common.entities.BusinessActionTrailEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author S3-Developer
 */
@Entity
@Table(name = "ITEM_TYPE")
public class ItemType extends AbstractEntity implements Serializable{
    @Id
    @Column(name = "ITEM_TYPE_ID", columnDefinition = "NUMBER(11)")
    private int item_type_id;
    
    @Column(name = "ITEM_TYPE_NAME", columnDefinition = "Varchar2(100)")
    private String item_type_name;
    
    @Column(name = "APPROVAL_STATUS_ID", columnDefinition = "NUMBER(11)")
    private int approval_status_id;
    
    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(60)")
    private String approver;
    
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();
    
    public ItemType(){
        
    }
    
    //Varchar2(15)

    /**
     * @return the item_type_id
     */
    public int getItem_type_id() {
        return item_type_id;
    }

    /**
     * @param item_type_id the item_type_id to set
     */
    public void setItem_type_id(int item_type_id) {
        this.item_type_id = item_type_id;
    }

    /**
     * @return the item_type_name
     */
    public String getItem_type_name() {
        return item_type_name;
    }

    /**
     * @param item_type_name the item_type_name to set
     */
    public void setItem_type_name(String item_type_name) {
        this.item_type_name = item_type_name;
    }

    /**
     * @return the approval_status_id
     */
    public int getApproval_status_id() {
        return approval_status_id;
    }

    /**
     * @param approval_status_id the approval_status_id to set
     */
    public void setApproval_status_id(int approval_status_id) {
        this.approval_status_id = approval_status_id;
    }

    /**
     * @return the approver
     */
    public String getApprover() {
        return approver;
    }

    /**
     * @param approver the approver to set
     */
    public void setApprover(String approver) {
        this.approver = approver;
    }
}
