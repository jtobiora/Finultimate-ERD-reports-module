
package reporting.enums.promotion;

public enum InvMeasureType {
    ITEM_NAME("item_name"),
    BRAND_NAME("brand_name"),
    WAREHOUSE("warehouse");
    
    private String value;
    
    private InvMeasureType(String value){
	this.value = value;
    }
    
    public String getValue(){
    	return this.value;
    }
}
