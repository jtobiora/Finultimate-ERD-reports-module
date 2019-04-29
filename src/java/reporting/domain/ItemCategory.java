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
public class ItemCategory extends AbstractEntity implements Serializable{
    @Id
    @Column(name = "CATEGORY_ID", columnDefinition = "NUMBER(11)")
    private int category_id;
    
    @Column(name = "CATEGORY_NAME", columnDefinition = "Varchar2(100)")
    private String category_name;
    
    @Column(name = "CATEGORY_DESC", columnDefinition = "Varchar2(256)")
    private String category_desc;
    
    @Column(name = "PARENT_CATEGORY_ID", columnDefinition = "NUMBER(11)")
    private int parent_category_id;
    
    @Column(name = "APPROVAL_STATUS_ID", columnDefinition = "NUMBER(11)")
    private int approval_status_id;
     
    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(60)")
    private String approver;
    
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();
    
    public ItemCategory(){
        
    }

    /**
     * @return the category_id
     */
    public int getCategory_id() {
        return category_id;
    }

    /**
     * @param category_id the category_id to set
     */
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    /**
     * @return the category_name
     */
    public String getCategory_name() {
        return category_name;
    }

    /**
     * @param category_name the category_name to set
     */
    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    /**
     * @return the category_desc
     */
    public String getCategory_desc() {
        return category_desc;
    }

    /**
     * @param category_desc the category_desc to set
     */
    public void setCategory_desc(String category_desc) {
        this.category_desc = category_desc;
    }

    /**
     * @return the parent_category_id
     */
    public int getParent_category_id() {
        return parent_category_id;
    }

    /**
     * @param parent_category_id the parent_category_id to set
     */
    public void setParent_category_id(int parent_category_id) {
        this.parent_category_id = parent_category_id;
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
