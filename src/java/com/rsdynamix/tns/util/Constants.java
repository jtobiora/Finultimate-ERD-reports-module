/*
 * Constants.java
 *
 * Created on January 14, 2009, 9:55 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.rsdynamix.tns.util;

import java.io.File;

/**
 *
 * @author p-aniah
 */
public class Constants {
    
    public static final String TNS_PARENT_NAME = "database-tns-names";
    
    public static final String TNS_DB_INSTANCE_NAME = "database-instance";
    
    public static final String TNS_NAME_FIELD = "tns-name";
    
    public static final String TNS_DIVISION_FIELD = "business-division";
    
    public static final String TNS_DRIVER_NAME_FIELD = "driver-name";
    
    public static final String TNS_DATABASE_URL_FIELD = "database-url";
    
    public static final String TNS_SCHEMA_NAME_FIELD = "schema-name";
    
    public static final String TNS_PASSWORD_FIELD = "password";
    
    public static final String TNS_CONFIG_FOLDER = "tns_config";
    
    public static final String TNS_CONFIG_FILE = TNS_CONFIG_FOLDER+File.separator+"tns_config.xml";
    //
    public static final String DBMS_NAME_FIELD = "dbms-name";
    //
    public static final String FINULTIMATE_PU = "finultimatePU";
    //
    public static final String INSURE_PU = "insurePU";
    //
    public static final String ANNUITY_PU = "annuityPU";
    //
    public static final String COMMONS_PU = "commonsPU";
    //
    public static final String SERVER_DOCROOT_NAME = "docroot";
    //
    public static final String SERVER_CONFIG_NAME = "config";
    //
    public static final String SYSTEM_DOCS_FOLDER = "FUlt_Docs";
    //
    public static final String EMPLOYEE_PIXES_FOLDER = "Emp_Pixes";
    //
    public static String ACCT_RECEIVABLES_CODE = "1100";
    //
    public static String ACCT_COMMISSION_CODE = "5500";
    //
    public static String COMPANY_BANK_ACCT__CODE = "1001350045";
    //
    public static String SETTLEMENT_PAYABLE_ACCT = "2300";
    //
    public static String ANNUITY_TRAN_SRC_CODE = "T001";
    //
    public static String INVESTMENT_TRAN_SRC_CODE = "T004";
    //
    public static int GROSS_PAYMENT_INDICATOR = 1;
    //
    public static int NET_PAYMENT_INDICATOR = 2;
    //
    public static String STANDARD_RATE_NAME = "Standard";
    //
    public static int STANDARD_RATE_ID = 1;
    //
    public static String AGREED_PERCENT_RATE_NAME = "Percent";
    //
    public static int AGREED_PERCENT_RATE_ID = 2;
    //
    public static String AGREED_FLAT_RATE_NAME = "Flat";
    //
    public static int AGREED_FLAT_RATE_ID = 3;
    //
    public static String MALE_GENDER_CHAR = "M";
    //
    public static String FEMALE_GENDER_CHAR = "F";
    //
    public static final String CRMSALES_PU = "crmsalesPU";
    //
    public static final String CHURCH_PU = "churchPU";
    //
    public static final String ACADEMIX_PU = "academixPU";
    //
    public static final String HEALTH_INF_MGT_PU = "healthInfMgtPU";
    //
    
    /** Creates a new instance of Constants */
    public Constants() {
    }
    
}
