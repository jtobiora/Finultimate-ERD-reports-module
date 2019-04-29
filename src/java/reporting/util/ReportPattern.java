package reporting.util;

import reporting.domain.Supplier;


public class ReportPattern {
	
private Supplier supplier;
private ChunkReport report;

public Supplier getSupplier() {
	return supplier;
}
public void setSupplier(Supplier supplier) {
	this.supplier = supplier;
}
public ChunkReport getReport() {
	return report;
}
public void setReport(ChunkReport report) {
	this.report = report;
}
}
