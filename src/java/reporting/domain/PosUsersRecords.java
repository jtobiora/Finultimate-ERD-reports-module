/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting.domain;

import com.rsdynamix.abstractobjects.AbstractEntity;
import com.rsdynamix.dynamo.common.entities.BusinessActionTrailEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "POS_USERS_RECORDS")
public class PosUsersRecords extends AbstractEntity implements Serializable {

    @Id
    @Column(name = "USER_ID", columnDefinition = "NUMBER(20)")
    private long userID;

    @Column(name = "USER_BRANCH_ID", columnDefinition = "NUMBER(20)")
    private int userBranchID;
    
    @Column(name = "USER_BRANCH_NAME", columnDefinition = "Varchar2(255)")
    private String userBranchName;
    
    @Column(name = "USER_DEPARTMENT_ID", columnDefinition = "NUMBER(20)")
    private int userDepartmentID;
    
    @Column(name = "USER_DEPARTMENT_NAME", columnDefinition = "Varchar2(255)")
    private String userDepartmentName;
    
    @Column(name = "USER_EMAIL_ADDRESS", columnDefinition = "Varchar2(255)")
    private String userEmailAddress;
    
    @Column(name = "USER_EMPLOYEE_CODE", columnDefinition = "Varchar2(255)")
    private String userEmployeeCode;
    
    @Column(name = "USER_PASSWORD", columnDefinition = "Varchar2(255)")
    private String userPassword;
    
    @Column(name = "USER_ROLE_ID", columnDefinition = "NUMBER(20)")
    private int userRoleID;
    
    @Column(name = "USER_ROLE_NAME", columnDefinition = "Varchar2(255)")
    private String userRoleName;
    
    @Column(name = "USER_TENANT_DATABASE", columnDefinition = "Varchar2(255)")
    private String userTenantDatabase;
    
    @Column(name = "USER_USERNAME", columnDefinition = "Varchar2(255)")
    private String userUsername;
    
    private transient int approvalStatusID = 0;
    
    private transient String approver = "";
    
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();
    
    public PosUsersRecords() {
        userID = 0;
        
    }

   

    /**
     * @return the userBranchID
     */
    public int getUserBranchID() {
        return userBranchID;
    }

    /**
     * @param userBranchID the userBranchID to set
     */
    public void setUserBranchID(int userBranchID) {
        this.userBranchID = userBranchID;
    }

    /**
     * @return the userBranchName
     */
    public String getUserBranchName() {
        return userBranchName;
    }

    /**
     * @param userBranchName the userBranchName to set
     */
    public void setUserBranchName(String userBranchName) {
        this.userBranchName = userBranchName;
    }

    /**
     * @return the userDepartmentID
     */
    public int getUserDepartmentID() {
        return userDepartmentID;
    }

    /**
     * @param userDepartmentID the userDepartmentID to set
     */
    public void setUserDepartmentID(int userDepartmentID) {
        this.userDepartmentID = userDepartmentID;
    }

    /**
     * @return the userDepartmentName
     */
    public String getUserDepartmentName() {
        return userDepartmentName;
    }

    /**
     * @param userDepartmentName the userDepartmentName to set
     */
    public void setUserDepartmentName(String userDepartmentName) {
        this.userDepartmentName = userDepartmentName;
    }

    /**
     * @return the userEmailAddress
     */
    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    /**
     * @param userEmailAddress the userEmailAddress to set
     */
    public void setUserEmailAddress(String userEmailAddress) {
        this.userEmailAddress = userEmailAddress;
    }

    /**
     * @return the userEmployeeCode
     */
    public String getUserEmployeeCode() {
        return userEmployeeCode;
    }

    /**
     * @param userEmployeeCode the userEmployeeCode to set
     */
    public void setUserEmployeeCode(String userEmployeeCode) {
        this.userEmployeeCode = userEmployeeCode;
    }

    /**
     * @return the userPassword
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * @param userPassword the userPassword to set
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * @return the userRoleID
     */
    public int getUserRoleID() {
        return userRoleID;
    }

    /**
     * @param userRoleID the userRoleID to set
     */
    public void setUserRoleID(int userRoleID) {
        this.userRoleID = userRoleID;
    }

    /**
     * @return the userRoleName
     */
    public String getUserRoleName() {
        return userRoleName;
    }

    /**
     * @param userRoleName the userRoleName to set
     */
    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    /**
     * @return the userTenantDatabase
     */
    public String getUserTenantDatabase() {
        return userTenantDatabase;
    }

    /**
     * @param userTenantDatabase the userTenantDatabase to set
     */
    public void setUserTenantDatabase(String userTenantDatabase) {
        this.userTenantDatabase = userTenantDatabase;
    }

    /**
     * @return the userUsername
     */
    public String getUserUsername() {
        return userUsername;
    }

    /**
     * @param userUsername the userUsername to set
     */
    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
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
     * @return the userID
     */
    public long getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(long userID) {
        this.userID = userID;
    }
    
    
}
