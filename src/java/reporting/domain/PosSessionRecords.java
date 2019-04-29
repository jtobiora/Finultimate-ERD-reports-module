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
@Table(name = "POS_SESSION_RECORDS")
public class PosSessionRecords extends AbstractEntity implements Serializable {

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER(20)")
    private int posSessionRecordsID;
    
    @Column(name = "SESSION_CARD_COLLECTED", columnDefinition = "DOUBLE PRECISION")
    private double sessionCardCollected;
    
    @Column(name = "SESSION_CASH_COLLECTED", columnDefinition = "DOUBLE PRECISION")
    private double sessionCashCollected;
    
    @Column(name = "SESSION_END_TIME", columnDefinition = "Varchar2(255)")
    private String sessionEndTime;
    
    @Column(name = "SESSION_LOYALTY_PAYMENT", columnDefinition = "DOUBLE PRECISION")
    private double sessionLoyaltyPayment;
    
    @Column(name = "SESSION_NAME", columnDefinition = "Varchar2(255)")
    private String sessionName;
    
    @Column(name = "SESSION_START_TIME", columnDefinition = "Varchar2(255)")
    private String sessionStartTime;
    
    @Column(name = "SESSION_STATE", columnDefinition = "Varchar2(255)")
    private String sessionState;
    
    @Column(name = "SESSION_TOTAL", columnDefinition = "DOUBLE PRECISION")
    private double sessionTotal;
    
    @Column(name = "SESSION_TOTAL_BALANCE", columnDefinition = "DOUBLE PRECISION")
    private double sessionTotalBalance;
    
    @Column(name = "SESSION_TOTAL_REFUNDS", columnDefinition = "DOUBLE PRECISION")
    private double sessionTotalRefunds;
    
    @Column(name = "SESSION_USER", columnDefinition = "NUMBER(20)")
    private int sessionUser;
    
    private transient int approvalStatusID = 0;
    
    private transient String approver = "";
    
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();
    
    public PosSessionRecords() {
        posSessionRecordsID = 0;
        
    }

    /**
     * @return the posSessionRecordsID
     */
    public int getPosSessionRecordsID() {
        return posSessionRecordsID;
    }

    /**
     * @param posSessionRecordsID the posSessionRecordsID to set
     */
    public void setPosSessionRecordsID(int posSessionRecordsID) {
        this.posSessionRecordsID = posSessionRecordsID;
    }

    /**
     * @return the sessionCardCollected
     */
    public double getSessionCardCollected() {
        return sessionCardCollected;
    }

    /**
     * @param sessionCardCollected the sessionCardCollected to set
     */
    public void setSessionCardCollected(double sessionCardCollected) {
        this.sessionCardCollected = sessionCardCollected;
    }

    /**
     * @return the sessionCashCollected
     */
    public double getSessionCashCollected() {
        return sessionCashCollected;
    }

    /**
     * @param sessionCashCollected the sessionCashCollected to set
     */
    public void setSessionCashCollected(double sessionCashCollected) {
        this.sessionCashCollected = sessionCashCollected;
    }

    /**
     * @return the sessionEndTime
     */
    public String getSessionEndTime() {
        return sessionEndTime;
    }

    /**
     * @param sessionEndTime the sessionEndTime to set
     */
    public void setSessionEndTime(String sessionEndTime) {
        this.sessionEndTime = sessionEndTime;
    }

    /**
     * @return the sessionLoyaltyPayment
     */
    public double getSessionLoyaltyPayment() {
        return sessionLoyaltyPayment;
    }

    /**
     * @param sessionLoyaltyPayment the sessionLoyaltyPayment to set
     */
    public void setSessionLoyaltyPayment(double sessionLoyaltyPayment) {
        this.sessionLoyaltyPayment = sessionLoyaltyPayment;
    }

    /**
     * @return the sessionName
     */
    public String getSessionName() {
        return sessionName;
    }

    /**
     * @param sessionName the sessionName to set
     */
    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    /**
     * @return the sessionStartTime
     */
    public String getSessionStartTime() {
        return sessionStartTime;
    }

    /**
     * @param sessionStartTime the sessionStartTime to set
     */
    public void setSessionStartTime(String sessionStartTime) {
        this.sessionStartTime = sessionStartTime;
    }

    /**
     * @return the sessionState
     */
    public String getSessionState() {
        return sessionState;
    }

    /**
     * @param sessionState the sessionState to set
     */
    public void setSessionState(String sessionState) {
        this.sessionState = sessionState;
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
     * @return the sessionTotalBalance
     */
    public double getSessionTotalBalance() {
        return sessionTotalBalance;
    }

    /**
     * @param sessionTotalBalance the sessionTotalBalance to set
     */
    public void setSessionTotalBalance(double sessionTotalBalance) {
        this.sessionTotalBalance = sessionTotalBalance;
    }

    /**
     * @return the sessionTotalRefunds
     */
    public double getSessionTotalRefunds() {
        return sessionTotalRefunds;
    }

    /**
     * @param sessionTotalRefunds the sessionTotalRefunds to set
     */
    public void setSessionTotalRefunds(double sessionTotalRefunds) {
        this.sessionTotalRefunds = sessionTotalRefunds;
    }

    /**
     * @return the sessionUser
     */
    public int getSessionUser() {
        return sessionUser;
    }

    /**
     * @param sessionUser the sessionUser to set
     */
    public void setSessionUser(int sessionUser) {
        this.sessionUser = sessionUser;
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
