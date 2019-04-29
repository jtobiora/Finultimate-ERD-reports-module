package reporting.util;

import java.util.Date;
import java.util.List;

public class ItemReports {
private List<String> brandNames;
private Date entryDate;
private Date purchaseOrderDate;
private Integer deliveryTimeInDays;
private String purchaseOrderNo;

public String getPurchaseOrderNo() {
	return purchaseOrderNo;
}
public void setPurchaseOrderNo(String purchaseOrderNo) {
	this.purchaseOrderNo = purchaseOrderNo;
}

public List<String> getBrandNames() {
	return brandNames;
}
public void setBrandNames(List<String> brandNames) {
	this.brandNames = brandNames;
}
public Date getEntryDate() {
	return entryDate;
}
public void setEntryDate(Date entryDate) {
	this.entryDate = entryDate;
}
public Date getPurchaseOrderDate() {
	return purchaseOrderDate;
}
public void setPurchaseOrderDate(Date purchaseOrderDate) {
	this.purchaseOrderDate = purchaseOrderDate;
}
public Integer getDeliveryTimeInDays() {
	return deliveryTimeInDays;
}
public void setDeliveryTimeInDays(Integer deliveryTimeInDays) {
	this.deliveryTimeInDays = deliveryTimeInDays;
}

}
