
package reporting.enums.promotion;

public enum InvReportType {
    EXPIRY_lIST(1), AVAILABILITY_REPORT(2), STOCK_AGING(3), 
	STOCK_VALUE(4), BEST_SELLING(5), WORST_SELLING(6), 
	BELOW_MIN_QTY(7), STOCK_MOVT(8), STOCK_LISTING(9);

	private Integer value;

	private InvReportType(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return this.value;
	}
}
