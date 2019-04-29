/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s3.systems.reporting.enums.sales;

/**
 *
 * @author ObinnaAsuzu
 */
public enum PaymentMethod {
    ACCOUNT("Account"),
    CARD("Card"),
    CASH("Cash"),
    CREDIT("Credit"),
    LOYALTY("Loyalty"),
    TRANSFER("Transfer");
    
    String value;

    private PaymentMethod(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
    
}
