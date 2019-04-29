/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s3.systems.reporting.enums.report;

/**
 *
 * @author ObinnaAsuzu
 */
public enum ChartType {
    LINE_CHART("Line Chart"),
    PIE_CAHRT("Pie Chart"),
    BAR_CHART("Bar Chart"),
    SCATTER_DIAGRAM("Scatter Diagram");
    String value;
    private ChartType(String value) { 
        this.value= value;
    }

    @Override
    public String toString() {
        return value;
    }
    
    
    
}
