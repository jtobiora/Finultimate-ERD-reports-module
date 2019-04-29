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
public enum RangeType {
    DAY("Day"),
    MONTH("Month"),
    YEAR("Year"),
    RANGE("Range");
    private String value;

    private RangeType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return  value;
    }
    
    
}