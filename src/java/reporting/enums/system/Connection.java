/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s3.systems.reporting.enums.system;

/**
 *
 * @author ObinnaAsuzu
 */
public enum Connection {
    OFFLINE("Offline"),
    ONLINE("ONline");
    
    String value;

    private Connection(String value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return value;
    }
    
}
