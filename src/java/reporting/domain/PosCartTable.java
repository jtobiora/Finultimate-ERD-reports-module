/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting.domain;

import com.rsdynamix.abstractobjects.AbstractEntity;
import com.rsdynamix.dynamo.common.entities.BusinessActionTrailEntity;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 *
 * @author israel
 */

@Entity
@Table(name="POS_CART_TABLE")
public class PosCartTable extends AbstractEntity implements Serializable{
    
    @Id
    @Column(name = "ID", columnDefinition = "NUMBER(20)")
    private long posCartID;
    
    @Column(name = "CART_VAT", columnDefinition = "DOUBLE PRECISION")
    private double cartVAT;
    
    @Column(name = "CART_COST", columnDefinition = "DOUBLE PRECISION")
    private double cartCost;
    
    @Column(name = "CART_SIZE", columnDefinition = "NUMBER(11)")
    private int cartSize;
    
    @Column(name = "CART_VALUE", columnDefinition = "DOUBLE PRECISION")
    private double cartValue;
    
    @Column(name = "REFUNDENTITY_ID", columnDefinition = "NUMBER(20)")
    private int refundentityID;
    
    private transient int approvalStatusID = 0;
    
    private transient String approver = "";
    
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();
    
    private transient Collection<PosCartItem> posCartItemCollection;
    
    public PosCartTable() {
        posCartID = 0;       
    }
    
    public boolean equals(Object o){
        boolean eqls = false;

        if(o instanceof PosCartTable) {
            if((((PosCartTable)o).getPosCartID() > 0) &&
                    (((PosCartTable)o).getPosCartID() == this.getPosCartID())){
                eqls = true;
            }
        }

        return eqls;
    }

   

    /**
     * @return the cartVAT
     */
    public double getCartVAT() {
        return cartVAT;
    }

    /**
     * @param cartVAT the cartVAT to set
     */
    public void setCartVAT(double cartVAT) {
        this.cartVAT = cartVAT;
    }

    /**
     * @return the cartCost
     */
    public double getCartCost() {
        return cartCost;
    }

    /**
     * @param cartCost the cartCost to set
     */
    public void setCartCost(double cartCost) {
        this.cartCost = cartCost;
    }

    /**
     * @return the cartSize
     */
    public int getCartSize() {
        return cartSize;
    }

    /**
     * @param cartSize the cartSize to set
     */
    public void setCartSize(int cartSize) {
        this.cartSize = cartSize;
    }

    /**
     * @return the cartValue
     */
    public double getCartValue() {
        return cartValue;
    }

    /**
     * @param cartValue the cartValue to set
     */
    public void setCartValue(double cartValue) {
        this.cartValue = cartValue;
    }

    /**
     * @return the refundentityID
     */
    public int getRefundentityID() {
        return refundentityID;
    }

    /**
     * @param refundentityID the refundentityID to set
     */
    public void setRefundentityID(int refundentityID) {
        this.refundentityID = refundentityID;
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

    /**
     * @return the posCartItemCollection
     */
    public Collection<PosCartItem> getPosCartItemCollection() {
        return posCartItemCollection;
    }

    /**
     * @param posCartItemCollection the posCartItemCollection to set
     */
    public void setPosCartItemCollection(Collection<PosCartItem> posCartItemCollection) {
        this.posCartItemCollection = posCartItemCollection;
    }

    /**
     * @return the posCartID
     */
    public long getPosCartID() {
        return posCartID;
    }

    /**
     * @param posCartID the posCartID to set
     */
    public void setPosCartID(long posCartID) {
        this.posCartID = posCartID;
    }

    }
