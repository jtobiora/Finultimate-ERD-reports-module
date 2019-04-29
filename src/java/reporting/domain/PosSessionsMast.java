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
@Table(name = "POS_SESSIONS_MAST")
public class PosSessionsMast extends AbstractEntity implements Serializable {

    @Id
    @Column(name = "ENTITY_MASTER_ID", columnDefinition = "NUMBER(11)")
    private int entityMasterID;
    
    @Column(name = "POS_SESSION_ID", columnDefinition = "NUMBER(11)")
    private int posSessionID;
    
    @Column(name = "POS_SESSION_NAME", columnDefinition = "Varchar2(100)")
    private String posSessionName;
    
    @Column(name = "POS_SESSION_START_TIME", columnDefinition = "Varchar2(60)")
    private String posSessionStartTime;
    
    @Column(name = "POS_SESSION_END_TIME", columnDefinition = "Varchar2(60)")
    private String posSessionEndTime;
    
    @Column(name = "POS_SESSION_USER_ID", columnDefinition = "NUMBER(11)")
    private int posSessionUserID;
    
    @Column(name = "POS_SESSION_USER_NAME", columnDefinition = "Varchar2(60)")
    private String posSessionUsername;
    
    @Column(name = "POS_SESSION_CASH_TOTAL", columnDefinition = "DOUBLE PRECISION")
    private double posSessionCashTotal;
    
    @Column(name = "POS_SESSION_CARD_TOTAL", columnDefinition = "DOUBLE PRECISION")
    private double posSessionCardTotal;
    
    @Column(name = "POS_SESSION_LOYALTY_TOTAL", columnDefinition = "DOUBLE PRECISION")
    private double posSessionLoyaltyTotal;
    
    @Column(name = "SESSION_REFUND_TOTAL", columnDefinition = "DOUBLE PRECISION")
    private double sessionRefundTotal;
    
    @Column(name = "POS_SESSION_STATE_FLAG", columnDefinition = "Varchar2(60)")
    private String posSessionStateFlag;
    
    private int approvalStatusID;
    
    private String approver;
    
    @Column(name = "SESSION_TOTAL", columnDefinition = "DOUBLE PRECISION")
    private double sessionTotal;
    
    @Column(name = "SESSION_BALANCES_TOTAL", columnDefinition = "DOUBLE PRECISION")
    private double sessionBalancesTotal;
    
    @Column(name = "POS_SESSION_USER_PASSWORD", columnDefinition = "Varchar2(60)")
    private String posSessionUserPassword;
    
    @Column(name = "POS_APPLICATION_ID", columnDefinition = "NUMBER(11)")
    private int posApplicationID;
    
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();
    
    public PosSessionsMast() {
        entityMasterID = 0;
        
    }

    /**
     * @return the entityMasterID
     */
    public int getEntityMasterID() {
        return entityMasterID;
    }

    /**
     * @param entityMasterID the entityMasterID to set
     */
    public void setEntityMasterID(int entityMasterID) {
        this.entityMasterID = entityMasterID;
    }

    /**
     * @return the posSessionID
     */
    public int getPosSessionID() {
        return posSessionID;
    }

    /**
     * @param posSessionID the posSessionID to set
     */
    public void setPosSessionID(int posSessionID) {
        this.posSessionID = posSessionID;
    }

    /**
     * @return the posSessionName
     */
    public String getPosSessionName() {
        return posSessionName;
    }

    /**
     * @param posSessionName the posSessionName to set
     */
    public void setPosSessionName(String posSessionName) {
        this.posSessionName = posSessionName;
    }

    /**
     * @return the posSessionStartTime
     */
    public String getPosSessionStartTime() {
        return posSessionStartTime;
    }

    /**
     * @param posSessionStartTime the posSessionStartTime to set
     */
    public void setPosSessionStartTime(String posSessionStartTime) {
        this.posSessionStartTime = posSessionStartTime;
    }

    /**
     * @return the posSessionEndTime
     */
    public String getPosSessionEndTime() {
        return posSessionEndTime;
    }

    /**
     * @param posSessionEndTime the posSessionEndTime to set
     */
    public void setPosSessionEndTime(String posSessionEndTime) {
        this.posSessionEndTime = posSessionEndTime;
    }

    /**
     * @return the posSessionUserID
     */
    public int getPosSessionUserID() {
        return posSessionUserID;
    }

    /**
     * @param posSessionUserID the posSessionUserID to set
     */
    public void setPosSessionUserID(int posSessionUserID) {
        this.posSessionUserID = posSessionUserID;
    }

    /**
     * @return the posSessionUsername
     */
    public String getPosSessionUsername() {
        return posSessionUsername;
    }

    /**
     * @param posSessionUsername the posSessionUsername to set
     */
    public void setPosSessionUsername(String posSessionUsername) {
        this.posSessionUsername = posSessionUsername;
    }

    /**
     * @return the posSessionCashTotal
     */
    public double getPosSessionCashTotal() {
        return posSessionCashTotal;
    }

    /**
     * @param posSessionCashTotal the posSessionCashTotal to set
     */
    public void setPosSessionCashTotal(double posSessionCashTotal) {
        this.posSessionCashTotal = posSessionCashTotal;
    }

    /**
     * @return the posSessionCardTotal
     */
    public double getPosSessionCardTotal() {
        return posSessionCardTotal;
    }

    /**
     * @param posSessionCardTotal the posSessionCardTotal to set
     */
    public void setPosSessionCardTotal(double posSessionCardTotal) {
        this.posSessionCardTotal = posSessionCardTotal;
    }

    /**
     * @return the posSessionLoyaltyTotal
     */
    public double getPosSessionLoyaltyTotal() {
        return posSessionLoyaltyTotal;
    }

    /**
     * @param posSessionLoyaltyTotal the posSessionLoyaltyTotal to set
     */
    public void setPosSessionLoyaltyTotal(double posSessionLoyaltyTotal) {
        this.posSessionLoyaltyTotal = posSessionLoyaltyTotal;
    }

    /**
     * @return the sessionRefundTotal
     */
    public double getSessionRefundTotal() {
        return sessionRefundTotal;
    }

    /**
     * @param sessionRefundTotal the sessionRefundTotal to set
     */
    public void setSessionRefundTotal(double sessionRefundTotal) {
        this.sessionRefundTotal = sessionRefundTotal;
    }

    /**
     * @return the posSessionStateFlag
     */
    public String getPosSessionStateFlag() {
        return posSessionStateFlag;
    }

    /**
     * @param posSessionStateFlag the posSessionStateFlag to set
     */
    public void setPosSessionStateFlag(String posSessionStateFlag) {
        this.posSessionStateFlag = posSessionStateFlag;
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
     * @return the sessionTotal
     */
    public double getSessionTotal() {
        return sessionTotal;
    }

    /**
     * @param sessionTotal the sessionTotal to set
     */
    public void setSessionTotal(double sessionTotal) {
        this.sessionTotal = sessionTotal;
    }

    /**
     * @return the sessionBalancesTotal
     */
    public double getSessionBalancesTotal() {
        return sessionBalancesTotal;
    }

    /**
     * @param sessionBalancesTotal the sessionBalancesTotal to set
     */
    public void setSessionBalancesTotal(double sessionBalancesTotal) {
        this.sessionBalancesTotal = sessionBalancesTotal;
    }

    /**
     * @return the posSessionUserPassword
     */
    public String getPosSessionUserPassword() {
        return posSessionUserPassword;
    }

    /**
     * @param posSessionUserPassword the posSessionUserPassword to set
     */
    public void setPosSessionUserPassword(String posSessionUserPassword) {
        this.posSessionUserPassword = posSessionUserPassword;
    }

    /**
     * @return the posApplicationID
     */
    public int getPosApplicationID() {
        return posApplicationID;
    }

    /**
     * @param posApplicationID the posApplicationID to set
     */
    public void setPosApplicationID(int posApplicationID) {
        this.posApplicationID = posApplicationID;
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
