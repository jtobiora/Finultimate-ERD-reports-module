/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting.util;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.rsdynamix.abstractobjects.AbstractEntity;

/**
 *
 * @author S3-Developer
 */
public class ExcludeFieldsInJSON implements ExclusionStrategy {
     public boolean shouldSkipClass(Class<?> arg0) {
            return false;
        }

        public boolean shouldSkipField(FieldAttributes f) {

            return (f.getDeclaringClass() == AbstractEntity.class && f.getName().equals("operatorHolder"))||
            (f.getDeclaringClass() == AbstractEntity.class && f.getName().equals("queryOperators"))||
            (f.getDeclaringClass() == AbstractEntity.class && f.getName().equals("queryRangeMap"))||
            (f.getDeclaringClass() == AbstractEntity.class && f.getName().equals("queryGateOperators"))||
            (f.getDeclaringClass() == AbstractEntity.class && f.getName().equals("queryInclusionSetList"))||
            (f.getDeclaringClass() == AbstractEntity.class && f.getName().equals("limitCount"))||
            (f.getDeclaringClass() == AbstractEntity.class && f.getName().equals("selected"))||
            (f.getDeclaringClass() == AbstractEntity.class && f.getName().equals("activated"))||
            (f.getDeclaringClass() == AbstractEntity.class && f.getName().equals("suppressAuditTrail"));
        }

}
