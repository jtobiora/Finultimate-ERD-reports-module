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
import reporting.domain.PosItemRecord;
import reporting.repository.ItemTableRepository;

/**
 *
 * @author S3-Developer
 */
@javax.faces.bean.SessionScoped
@ManagedBean(name = "itemTableBean")
public class ItemTableBean implements Serializable, ItemTableRepository {

    private PosItemRecord posItemRecord;
    private List<PosItemRecord> posItemRecordList ;
    
    private FinultimatePersistenceRemote dataServer = FinanceServiceLocator.locateFinancePersistenceManager();
    
    /**
     * Creates a new instance of ItemTableBean
     */
    public ItemTableBean() {
        posItemRecord = new PosItemRecord();
        posItemRecordList = new ArrayList<PosItemRecord>();
    }

    @Override
    public List<PosItemRecord> getItemsBetweenDatesByProduct(Date startDate, Date endDate, Long pid) throws ParseException{
        
        //String dateStr = "Mon Jan 02 00:00:00 WAT 2017";
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
            PosItemRecord criteria = new PosItemRecord();
            List<AbstractEntity> entityList = getDataServer().findData(criteria,"SELECT p.* FROM pos_transaction_records t, pos_cart_table c, pos_cart_item i, "
                    + "pos_item_record p WHERE TIMESTAMP(t.TRANSACTION_DATE) >= TIMESTAMP('"+formatedStartDate+"') AND TIMESTAMP(t.TRANSACTION_DATE) <= TIMESTAMP('"+formatedEndDate+"') AND "
                    + "c.id = t.CART_ID AND i.CART_ID = c.id AND i.ITEM_ID = p.ID AND p.ID = '"+pid+"'");

            for (AbstractEntity entity : entityList) {
                PosItemRecord posItemRecordEntity = (PosItemRecord) entity;

                getPosItemRecordList().add(posItemRecordEntity);
            }
                      
        } catch (Exception ex) {
            ex.printStackTrace();
            
        }
        return posItemRecordList;
    }

    @Override
    public List<PosItemRecord> getItemsBetweenDatesByUser(Date startDate, Date endDate, Long uid) throws ParseException{
        //String dateStr = "Mon Jan 02 00:00:00 WAT 2017";
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
            PosItemRecord criteria = new PosItemRecord();
            List<AbstractEntity> entityList = getDataServer().findData(criteria,"SELECT p.* FROM pos_transaction_records t, pos_cart_table c, pos_cart_item i, "
                    + "pos_item_record p WHERE TIMESTAMP(t.TRANSACTION_DATE) >= TIMESTAMP('"+formatedStartDate+"') AND TIMESTAMP(t.TRANSACTION_DATE) <= TIMESTAMP('"+formatedEndDate+"') AND "
                    + "c.id = t.CART_ID AND i.CART_ID = c.id AND i.ITEM_ID = p.ID AND t.TRANSACTION_USER ='"+uid+"'");

            for (AbstractEntity entity : entityList) {
                PosItemRecord posItemRecordEntity = (PosItemRecord) entity;

                getPosItemRecordList().add(posItemRecordEntity);
            }
                      
        } catch (Exception ex) {
            ex.printStackTrace();
            
        }
        return posItemRecordList;
    }

    /**
     * @return the posItemRecord
     */
    public PosItemRecord getPosItemRecord() {
        return posItemRecord;
    }

    /**
     * @param posItemRecord the posItemRecord to set
     */
    public void setPosItemRecord(PosItemRecord posItemRecord) {
        this.posItemRecord = posItemRecord;
    }

    /**
     * @return the posItemRecordList
     */
    public List<PosItemRecord> getPosItemRecordList() {
        return posItemRecordList;
    }

    /**
     * @param posItemRecordList the posItemRecordList to set
     */
    public void setPosItemRecordList(List<PosItemRecord> posItemRecordList) {
        this.posItemRecordList = posItemRecordList;
    }

    /**
     * @return the dataServer
     */
    public FinultimatePersistenceRemote getDataServer() {
        return dataServer;
    }

    /**
     * @param dataServer the dataServer to set
     */
    public void setDataServer(FinultimatePersistenceRemote dataServer) {
        this.dataServer = dataServer;
    }
    
}
