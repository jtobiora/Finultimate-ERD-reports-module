/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting.beans;

import com.rsdynamics.projects.eao.FinultimatePersistenceRemote;
import com.rsdynamix.abstractobjects.AbstractEntity;
import com.rsdynamix.projects.binding.FinanceServiceLocator;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import reporting.domain.PosCartItem;
import reporting.domain.PosCartTable;
import reporting.domain.PosTransactionRecords;
import reporting.repository.TransactionRepository;

/**
 *
 * @author S3-Developer
 */
@javax.faces.bean.SessionScoped
@ManagedBean(name = "transactionBean")
public class TransactionBean implements Serializable, TransactionRepository {

    private PosTransactionRecords posCartTable;
    private List<PosCartTable> posCartTableList;
    
    private PosTransactionRecords posTransactionRecords;
    private List<PosTransactionRecords> posTransactionRecordsList;

    FinultimatePersistenceRemote dataServer = FinanceServiceLocator.locateFinancePersistenceManager();

    /**
     * Creates a new instance of TransactionBean
     */
    public TransactionBean() {
        posCartTable = new PosTransactionRecords();
        posCartTableList = new ArrayList<>();
        posTransactionRecords = new PosTransactionRecords();
        posTransactionRecordsList = new ArrayList<>();
    }

    @Override
    public List<PosCartTable> getTransactionsBetweenDates(Date startDate, Date endDate) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        Date date1 = (Date) formatter.parse(startDate.toString());
        Date date2 = (Date) formatter.parse(endDate.toString());
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        String formatedStartDate = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DATE);
       
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        String formatedEndDate = cal2.get(Calendar.YEAR) + "-" + (cal2.get(Calendar.MONTH) + 1) + "-" + cal2.get(Calendar.DATE);
       
        try {
            PosCartTable criteria = new PosCartTable();
            List<AbstractEntity> entityList = dataServer.findData(criteria, "SELECT pct.* FROM pos_transaction_records ptr, pos_cart_table pct "
                    + "WHERE TIMESTAMP(ptr.TRANSACTION_DATE) >= TIMESTAMP('" + formatedStartDate +"') "
                    + "AND TIMESTAMP(ptr.TRANSACTION_DATE) <= TIMESTAMP('"+formatedEndDate+"') "
                    + "AND ptr.CART_ID = pct.ID");
            
            for (AbstractEntity entity : entityList) {
                PosCartTable posTransactionRecordsEntity = (PosCartTable) entity;
                getPosCartTableList().add(posTransactionRecordsEntity);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //System.out.println(posCartTableList.size());
        return posCartTableList;
    }
    
    public List<PosTransactionRecords> getTransactionsBetweenDates1(Date startDate, Date endDate) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        Date date1 = (Date) formatter.parse(startDate.toString());
        Date date2 = (Date) formatter.parse(endDate.toString());
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        String formatedStartDate = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DATE);
       
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        String formatedEndDate = cal2.get(Calendar.YEAR) + "-" + (cal2.get(Calendar.MONTH) + 1) + "-" + cal2.get(Calendar.DATE);
       
        try {
            PosTransactionRecords criteria = new PosTransactionRecords();
            List<AbstractEntity> entityList = dataServer.findData(criteria, "SELECT t.* FROM pos_transaction_records t "
                    + "WHERE TIMESTAMP(t.TRANSACTION_DATE) >= TIMESTAMP('"+formatedStartDate+"') "
                    + "AND TIMESTAMP(t.TRANSACTION_DATE) <= TIMESTAMP('"+formatedEndDate+"')");
            
            for (AbstractEntity entity : entityList) {
                PosTransactionRecords posTransactionRecordsEntity = (PosTransactionRecords) entity;
                getPosTransactionRecordsList().add(posTransactionRecordsEntity);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //System.out.println(posCartTableList.size());
        return posTransactionRecordsList;
    }

    @Override
    public List<PosCartTable> getTransactionsBetweenDatesByUser(Date startDate, Date endDate, Long userId) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        Date date1 = (Date) formatter.parse(startDate.toString());
        Date date2 = (Date) formatter.parse(endDate.toString());
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        String formatedStartDate = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DATE);
        
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        String formatedEndDate = cal2.get(Calendar.YEAR) + "-" + (cal2.get(Calendar.MONTH) + 1) + "-" + cal2.get(Calendar.DATE);
        
        try {
            PosCartTable criteria = new PosCartTable();
            List<AbstractEntity> entityList = dataServer.findData(criteria, "SELECT pct.* FROM pos_transaction_records ptr, pos_cart_table pct "
                    + "WHERE ptr.TRANSACTION_USER = '"+userId+"' "
                    + "AND TIMESTAMP(ptr.TRANSACTION_DATE) >= TIMESTAMP('"+formatedStartDate+"') "
                    + "AND TIMESTAMP(ptr.TRANSACTION_DATE) <= TIMESTAMP('"+formatedEndDate+"') "
                    + "AND ptr.CART_ID = pct.ID");

            for (AbstractEntity entity : entityList) {
                PosCartTable posCartTableEntity = (PosCartTable) entity;

                getPosCartTableList().add(posCartTableEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return posCartTableList;
    }
    
    public List<PosTransactionRecords> getTransactionsBetweenDatesByUser1(Date startDate, Date endDate, Long userId) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        Date date1 = (Date) formatter.parse(startDate.toString());
        Date date2 = (Date) formatter.parse(endDate.toString());
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        String formatedStartDate = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DATE);
        
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        String formatedEndDate = cal2.get(Calendar.YEAR) + "-" + (cal2.get(Calendar.MONTH) + 1) + "-" + cal2.get(Calendar.DATE);
        
        try {
            PosTransactionRecords criteria = new PosTransactionRecords();
            List<AbstractEntity> entityList = dataServer.findData(criteria, "SELECT ptr.* FROM pos_transaction_records ptr "
                    + "WHERE ptr.TRANSACTION_USER = '"+userId+"' "
                    + "AND TIMESTAMP(ptr.TRANSACTION_DATE) >= TIMESTAMP('"+formatedStartDate+"') "
                    + "AND TIMESTAMP(ptr.TRANSACTION_DATE) <= TIMESTAMP('"+formatedEndDate+"')");

            for (AbstractEntity entity : entityList) {
                PosTransactionRecords posTransactionRecordsEntity = (PosTransactionRecords) entity;

                getPosTransactionRecordsList().add(posTransactionRecordsEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return posTransactionRecordsList;
    }

    @Override
    public List<PosCartTable> getTransactionsBetweenDatesByOutlet(Date startDate, Date endDate, String outletName) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        Date date1 = (Date) formatter.parse(startDate.toString());
        System.out.println(date1);

        // String dateStr = "Mon Jan 02 00:00:00 WAT 2017";
        Date date2 = (Date) formatter.parse(endDate.toString());
        System.out.println(date2);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        String formatedStartDate = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DATE);
        //System.out.println("startDate : " + formatedStartDate);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        String formatedEndDate = cal2.get(Calendar.YEAR) + "-" + (cal2.get(Calendar.MONTH) + 1) + "-" + cal2.get(Calendar.DATE);
        // System.out.println("endDate : " + formatedEndDate);

        try {
            PosCartTable criteria = new PosCartTable();
            List<AbstractEntity> entityList = dataServer.findData(criteria, "SELECT pct.* FROM pos_transaction_records ptr, pos_cart_table pct "
                    + "WHERE ptr.OUTLET_NAME = '" + outletName + "' AND"
                    + " TIMESTAMP(ptr.TRANSACTION_DATE) >= TIMESTAMP('" + formatedStartDate + "') "
                    + "AND TIMESTAMP(ptr.TRANSACTION_DATE) <= TIMESTAMP('" + formatedEndDate + "')"
                    + "AND ptr.CART_ID = pct.ID");

            for (AbstractEntity entity : entityList) {
                PosCartTable posTransactionRecordsEntity = (PosCartTable) entity;

                getPosCartTableList().add(posTransactionRecordsEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return posCartTableList;
    }
    
    public List<PosTransactionRecords> getTransactionsBetweenDatesByOutlet1(Date startDate, Date endDate, String outletName) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        Date date1 = (Date) formatter.parse(startDate.toString());
        System.out.println(date1);

        // String dateStr = "Mon Jan 02 00:00:00 WAT 2017";
        Date date2 = (Date) formatter.parse(endDate.toString());
        System.out.println(date2);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        String formatedStartDate = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DATE);
        //System.out.println("startDate : " + formatedStartDate);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        String formatedEndDate = cal2.get(Calendar.YEAR) + "-" + (cal2.get(Calendar.MONTH) + 1) + "-" + cal2.get(Calendar.DATE);
        // System.out.println("endDate : " + formatedEndDate);

        try {
            PosTransactionRecords criteria = new PosTransactionRecords();
            List<AbstractEntity> entityList = dataServer.findData(criteria, "SELECT t.* FROM pos_transaction_records t WHERE t.OUTLET_NAME = '" + outletName + "' AND"
                    + " TIMESTAMP(t.TRANSACTION_DATE) >= TIMESTAMP('" + formatedStartDate + "') AND TIMESTAMP(t.TRANSACTION_DATE) <= TIMESTAMP('" + formatedEndDate + "')");

            for (AbstractEntity entity : entityList) {
                PosTransactionRecords posTransactionRecordsEntity = (PosTransactionRecords) entity;

                getPosTransactionRecordsList().add(posTransactionRecordsEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return posTransactionRecordsList;
    }

    @Override
    public List<String> getOutletsBetweenDates(Date startDate, Date endDate) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        Date date1 = (Date) formatter.parse(startDate.toString());
        System.out.println(date1);

        // String dateStr = "Mon Jan 02 00:00:00 WAT 2017";
        Date date2 = (Date) formatter.parse(endDate.toString());
        System.out.println(date2);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        String formatedStartDate = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DATE);
        //System.out.println("startDate : " + formatedStartDate);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        String formatedEndDate = cal2.get(Calendar.YEAR) + "-" + (cal2.get(Calendar.MONTH) + 1) + "-" + cal2.get(Calendar.DATE);
        // System.out.println("endDate : " + formatedEndDate);

        List<String> outlets = new ArrayList<String>();
        try {
            PosTransactionRecords criteria = new PosTransactionRecords();
            List<AbstractEntity> entityList = dataServer.findData(criteria, "SELECT t.* FROM pos_transaction_records t WHERE \n"
                    + "TIMESTAMP(t.TRANSACTION_DATE) >= TIMESTAMP('" + formatedStartDate + "') AND TIMESTAMP(t.TRANSACTION_DATE) <=\n"
                    + "TIMESTAMP('" + formatedEndDate + "')");

            for (AbstractEntity entity : entityList) {
                PosTransactionRecords posTransactionRecordsEntity = (PosTransactionRecords) entity;

                outlets.add(posTransactionRecordsEntity.getOutletName());
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return outlets;
    }

    @Override
    public List<PosCartTable> getTransactionsBetweenDatesByCustomer(Date startDate, Date endDate, String customerId) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        Date date1 = (Date) formatter.parse(startDate.toString());
        System.out.println(date1);

        // String dateStr = "Mon Jan 02 00:00:00 WAT 2017";
        Date date2 = (Date) formatter.parse(endDate.toString());
        System.out.println(date2);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        String formatedStartDate = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DATE);
        //System.out.println("startDate : " + formatedStartDate);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        String formatedEndDate = cal2.get(Calendar.YEAR) + "-" + (cal2.get(Calendar.MONTH) + 1) + "-" + cal2.get(Calendar.DATE);
        // System.out.println("endDate : " + formatedEndDate);

        try {
            PosCartTable criteria = new PosCartTable();
            List<AbstractEntity> entityList = dataServer.findData(criteria, "SELECT pct.* FROM pos_transaction_records ptr, pos_cart_table pct "
                    + "WHERE ptr.TRANSACTION_CUSTOMER = '"+customerId+"' "
                    + "AND TIMESTAMP(ptr.TRANSACTION_DATE) >= TIMESTAMP('"+formatedStartDate+"') "
                    + "AND TIMESTAMP(ptr.TRANSACTION_DATE) <= TIMESTAMP('"+formatedEndDate+"') "
                    + "AND ptr.CART_ID = pct.ID");

            for (AbstractEntity entity : entityList) {
                PosCartTable posCartTableEntity = (PosCartTable) entity;

                getPosCartTableList().add(posCartTableEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return posCartTableList;
    }
    
    public List<PosTransactionRecords> getTransactionsBetweenDatesByCustomer1(Date startDate, Date endDate, String customerId) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        Date date1 = (Date) formatter.parse(startDate.toString());
        System.out.println(date1);

        // String dateStr = "Mon Jan 02 00:00:00 WAT 2017";
        Date date2 = (Date) formatter.parse(endDate.toString());
        System.out.println(date2);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        String formatedStartDate = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DATE);
        //System.out.println("startDate : " + formatedStartDate);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        String formatedEndDate = cal2.get(Calendar.YEAR) + "-" + (cal2.get(Calendar.MONTH) + 1) + "-" + cal2.get(Calendar.DATE);
        // System.out.println("endDate : " + formatedEndDate);

        try {
            PosTransactionRecords criteria = new PosTransactionRecords();
            List<AbstractEntity> entityList = dataServer.findData(criteria, "SELECT ptr.* FROM pos_transaction_records ptr "
                    + "WHERE ptr.TRANSACTION_CUSTOMER = '"+customerId+"' "
                    + "AND TIMESTAMP(ptr.TRANSACTION_DATE) >= TIMESTAMP('"+formatedStartDate+"') "
                    + "AND TIMESTAMP(ptr.TRANSACTION_DATE) <= TIMESTAMP('"+formatedEndDate+"')");

            for (AbstractEntity entity : entityList) {
                PosTransactionRecords posTransactionRecordEntity = (PosTransactionRecords) entity;

                getPosTransactionRecordsList().add(posTransactionRecordEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return posTransactionRecordsList;
    }

    @Override
    public List<PosTransactionRecords> getTransactionsBetweenDatesByProduct(Date startDate, Date endDate, Long pid) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        Date date1 = (Date) formatter.parse(startDate.toString());
        System.out.println(date1);

        // String dateStr = "Mon Jan 02 00:00:00 WAT 2017";
        Date date2 = (Date) formatter.parse(endDate.toString());
        System.out.println(date2);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        String formatedStartDate = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DATE);
        //System.out.println("startDate : " + formatedStartDate);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        String formatedEndDate = cal2.get(Calendar.YEAR) + "-" + (cal2.get(Calendar.MONTH) + 1) + "-" + cal2.get(Calendar.DATE);
        // System.out.println("endDate : " + formatedEndDate);
        try {
            PosTransactionRecords criteria = new PosTransactionRecords();
            List<AbstractEntity> entityList = dataServer.findData(criteria, "SELECT t.* FROM pos_transaction_records t, pos_cart_table c, pos_cart_item i, \n"
                    + "                    pos_item_record p WHERE  TIMESTAMP(t.TRANSACTION_DATE) >= TIMESTAMP('" + formatedStartDate + "') AND \n"
                    + "                    TIMESTAMP(t.TRANSACTION_DATE) <= TIMESTAMP('" + formatedEndDate + "')\n"
                    + "                    AND c.id = t.CART_ID AND i.CART_ID = c.id AND i.ITEM_ID = p.id AND p.id = '" + pid + "' ");

            for (AbstractEntity entity : entityList) {
                PosTransactionRecords posTransactionRecordsEntity = (PosTransactionRecords) entity;

                getPosTransactionRecordsList().add(posTransactionRecordsEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return posTransactionRecordsList;
    }

    @Override
    public List<PosTransactionRecords> getTransactionsBetweenDatesByProductAndUser(Date startDate, Date endDate, Long pid, Long userId) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        Date date1 = (Date) formatter.parse(startDate.toString());
        System.out.println(date1);

        // String dateStr = "Mon Jan 02 00:00:00 WAT 2017";
        Date date2 = (Date) formatter.parse(endDate.toString());
        System.out.println(date2);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        String formatedStartDate = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DATE);
        //System.out.println("startDate : " + formatedStartDate);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        String formatedEndDate = cal2.get(Calendar.YEAR) + "-" + (cal2.get(Calendar.MONTH) + 1) + "-" + cal2.get(Calendar.DATE);
        // System.out.println("endDate : " + formatedEndDate);
        try {
            PosTransactionRecords criteria = new PosTransactionRecords();
            List<AbstractEntity> entityList = dataServer.findData(criteria, "SELECT t.* FROM pos_transaction_records t, pos_cart_table c, pos_cart_item i, \n"
                    + "                    pos_item_record p WHERE  TIMESTAMP(t.TRANSACTION_DATE) >= TIMESTAMP('" + formatedStartDate + "') AND \n"
                    + "                    TIMESTAMP(t.TRANSACTION_DATE) <= TIMESTAMP('" + formatedEndDate + "')\n"
                    + "                    AND c.id = t.CART_ID AND i.CART_ID = c.id AND i.ITEM_ID = p.id AND p.id = '" + pid + "' AND t.TRANSACTION_USER = '" + userId + "'");

            for (AbstractEntity entity : entityList) {
                PosTransactionRecords posTransactionRecordsEntity = (PosTransactionRecords) entity;

                getPosTransactionRecordsList().add(posTransactionRecordsEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return posTransactionRecordsList;
    }

    /**
     * @return the posCartTable
     */
    public PosTransactionRecords getPosCartTable() {
        return posCartTable;
    }

    /**
     * @param posCartTable the posCartTable to set
     */
    public void setPosCartTable(PosTransactionRecords posCartTable) {
        this.posCartTable = posCartTable;
    }

    /**
     * @return the posCartTableList
     */
    public List<PosCartTable> getPosCartTableList() {
        return posCartTableList;
    }

    /**
     * @param posCartTableList the posCartTableList to set
     */
    public void setPosCartTableList(List<PosCartTable> posCartTableList) {
        this.posCartTableList = posCartTableList;
    }

    /**
     * @return the posTransactionRecords
     */
    public PosTransactionRecords getPosTransactionRecords() {
        return posTransactionRecords;
    }

    /**
     * @param posTransactionRecords the posTransactionRecords to set
     */
    public void setPosTransactionRecords(PosTransactionRecords posTransactionRecords) {
        this.posTransactionRecords = posTransactionRecords;
    }

    /**
     * @return the posTransactionRecordsList
     */
    public List<PosTransactionRecords> getPosTransactionRecordsList() {
        return posTransactionRecordsList;
    }

    /**
     * @param posTransactionRecordsList the posTransactionRecordsList to set
     */
    public void setPosTransactionRecordsList(List<PosTransactionRecords> posTransactionRecordsList) {
        this.posTransactionRecordsList = posTransactionRecordsList;
    }

}
