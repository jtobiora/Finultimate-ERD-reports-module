package reporting.domain;

import com.rsdynamics.projects.query.operators.EntityOperatorHolder;
import com.rsdynamix.abstractobjects.AbstractEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STOCK_TRANSFR_REQ")
public class StockTransferReq extends AbstractEntity implements Serializable {

    @Id
    @Column(name = "STOCK_TRANSFR_REQ_ID", columnDefinition = "NUMBER(11)")
    private Integer stockTransferReqId;

    @Column(name = "STOCK_ITEM_ID", columnDefinition = "NUMBER(11)")
    private Integer stockItemId;

    @Column(name = "STOCK_UNIT_ITEM_ID", columnDefinition = "NUMBER(11)")
    private Integer stockUnitItemId;

    @Column(name = "QUANTITY", columnDefinition = "NUMBER(11)")
    private Integer quantity;

    @Column(name = "WAREHOUSE_ID", columnDefinition = "NUMBER(11)")
    private Integer warehouseId;

    @Column(name = "SECTION_ID", columnDefinition = "NUMBER(11)")
    private Integer sectionId;

    @Column(name = "SHELF_ID", columnDefinition = "NUMBER(11)")
    private Integer shelfId;

    @Column(name = "APPROVAL_STATUS_ID", columnDefinition = "NUMBER(11)")
    private Integer approvalStatusId;

    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(25)")
    private String approverName;

    @Column(name = "TRANSFR_STATUS", columnDefinition = "NUMBER(11)")
    private Integer transferStatus;

    @Column(name = "EFFECTIVE_DATE", columnDefinition = "DATE")
    private Date effectiveDate;

    public Integer getStockTransferReqId() {
        return stockTransferReqId;
    }

    public void setStockTransferReqId(Integer stockTransferReqId) {
        this.stockTransferReqId = stockTransferReqId;
    }

    public Integer getStockItemId() {
        return stockItemId;
    }

    public void setStockItemId(Integer stockItemId) {
        this.stockItemId = stockItemId;
    }

    public Integer getStockUnitItemId() {
        return stockUnitItemId;
    }

    public void setStockUnitItemId(Integer stockUnitItemId) {
        this.stockUnitItemId = stockUnitItemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public Integer getShelfId() {
        return shelfId;
    }

    public void setShelfId(Integer shelfId) {
        this.shelfId = shelfId;
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

    public Integer getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(Integer transferStatus) {
        this.transferStatus = transferStatus;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
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
