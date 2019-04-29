
package reporting.util;

import java.util.List;

public class InventoryReportPull {
    private List<InvItemNameDetails> reportDetails;

    public List<InvItemNameDetails> getReportDetails() {
	return reportDetails;
    }

    public void setReportDetails(List<InvItemNameDetails> reportDetails) {
	this.reportDetails = reportDetails;
    }
}
