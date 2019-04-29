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

@Entity
@Table(name="POS_CATEGORY_RECORDS")
public class PosCategoryRecords extends AbstractEntity implements Serializable{
    @Id
    @Column(name = "ID", columnDefinition = "NUMBER(20)")
    private int posCategoryRecordID;
    
    @Column(name = "CATEGORY_DESCRIPTION", columnDefinition = "Varchar2(255)")
    private String categoryDescription;
    
    @Column(name = "CATEGORY_NAME", columnDefinition = "Varchar2(255)")
    private String categoryName;
    
    @Column(name = "CATEGORY_PARENT_ID", columnDefinition = "NUMBER(20)")
    private int categoryParentID;
    
    private transient int approvalStatusID = 0;
    
    private transient String approver = "";
    
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();
    
    public PosCategoryRecords() {
        posCategoryRecordID = 0;
        
    }
    
    public boolean equals(Object o){
        boolean eqls = false;

        if(o instanceof PosCategoryRecords) {
            if((((PosCategoryRecords)o).getPosCategoryRecordID() > 0) &&
                    (((PosCategoryRecords)o).getPosCategoryRecordID() == this.getPosCategoryRecordID())){
                eqls = true;
            }
        }

        return eqls;
    }

    /**
     * @return the posCategoryRecordID
     */
    public int getPosCategoryRecordID() {
        return posCategoryRecordID;
    }

    /**
     * @param posCategoryRecordID the posCategoryRecordID to set
     */
    public void setPosCategoryRecordID(int posCategoryRecordID) {
        this.posCategoryRecordID = posCategoryRecordID;
    }

    /**
     * @return the categoryDescription
     */
    public String getCategoryDescription() {
        return categoryDescription;
    }

    /**
     * @param categoryDescription the categoryDescription to set
     */
    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    /**
     * @return the categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName the categoryName to set
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * @return the categoryParentID
     */
    public int getCategoryParentID() {
        return categoryParentID;
    }

    /**
     * @param categoryParentID the categoryParentID to set
     */
    public void setCategoryParentID(int categoryParentID) {
        this.categoryParentID = categoryParentID;
    }

    /**
     * @return the approvalStatusID
     */
    public int getApprovalStatusID() {
        return approvalStatusID;
    }

    /**
     * @param approvalStatusID the approvalStatusID to set
     */
    public void setApprovalStatusID(int approvalStatusID) {
        this.approvalStatusID = approvalStatusID;
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

    /**
     * @return the actionTrail
     */
    public BusinessActionTrailEntity getActionTrail() {
        return actionTrail;
    }

    /**
     * @param actionTrail the actionTrail to set
     */
    public void setActionTrail(BusinessActionTrailEntity actionTrail) {
        this.actionTrail = actionTrail;
    }

    }
