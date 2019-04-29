
package reporting.domain.pref;

import com.rsdynamics.projects.query.operators.EntityOperatorHolder;
import com.rsdynamix.abstractobjects.AbstractEntity;
import com.rsdynamix.dynamo.common.entities.BusinessActionTrailEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ITEM_WAREHOUSE")
public class ItemWarehouse_PF extends AbstractEntity implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(name = "WAREHOUSE_ID", columnDefinition = "NUMBER(11)")
    private Integer warehouseid;

    @Column(name = "WAREHOUSE_NAME", columnDefinition = "Varchar2(100)")
    private String warehouseName;

    @Column(name = "SUPPLIER_ID", columnDefinition = "Varchar2(15)")
    private String supplierId;

    @Column(name = "COUNTRY_ID", columnDefinition = "Varchar2(11)")
    private Integer countryId;

    @Column(name = "STATE_CODE", columnDefinition = "Varchar2(3)")
    private String stateCode;

    @Column(name = "CITY_ID", columnDefinition = "NUMBER(11)")
    private Integer cityId;

    @Column(name = "LOCATION_ADDRESS", columnDefinition = "Varchar2(256)")
    private String locationAddress;

    @Column(name = "APPROVAL_STATUS_ID", columnDefinition = "NUMBER(11)")
    private Integer approvalStatusId;

    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(60)")
    private String approverName;

    @Column(name = "DESCRIPTION", columnDefinition = "Varchar2(256)")
    private String description;

    @Column(name = "WAREHOUSE_DIM_TYP", columnDefinition = "NUMBER(11)")
    private Integer warehouseDimTyp;

    @Column(name = "WAREHOUSE_OWN_TYP", columnDefinition = "NUMBER(11)")
    private Integer warehouseOwnTyp;

    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();

    public Integer getWarehouseid() {
        return warehouseid;
    }

    public void setWarehouseid(Integer warehouseid) {
        this.warehouseid = warehouseid;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public Integer getApprovalStatusId() {
        return approvalStatusId;
    }

    public void setApprovalStatusId(Integer approvalStatusId) {
        this.approvalStatusId = approvalStatusId;
    }

    public String getApproverName() {
        return approverName;
    }

    public void setApproverName(String approverName) {
        this.approverName = approverName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWarehouseDimTyp() {
        return warehouseDimTyp;
    }

    public void setWarehouseDimTyp(Integer warehouseDimTyp) {
        this.warehouseDimTyp = warehouseDimTyp;
    }

    public Integer getWarehouseOwnTyp() {
        return warehouseOwnTyp;
    }

    public void setWarehouseOwnTyp(Integer warehouseOwnTyp) {
        this.warehouseOwnTyp = warehouseOwnTyp;
    }

    public BusinessActionTrailEntity getActionTrail() {
        return actionTrail;
    }

    public void setActionTrail(BusinessActionTrailEntity actionTrail) {
        this.actionTrail = actionTrail;
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
    
    

}
