/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting.beans;

import com.rsdynamics.projects.eao.FinultimatePersistenceRemote;
import com.rsdynamix.abstractobjects.AbstractEntity;
import com.rsdynamix.dynamo.messages.MessageType;
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
import javax.faces.model.SelectItem;
import reporting.domain.PosCartItem;
import reporting.domain.PosItemRecord;
import reporting.repository.CartItemRepository;

/**
 *
 * @author S3-Developer
 */
@javax.faces.bean.SessionScoped
@ManagedBean(name = "cartItemBean")
public class CartItemBean implements Serializable, CartItemRepository {

    private PosCartItem posCartItem;
    private List<PosCartItem> posCartItemList;
    private List<PosItemRecord> posItemRecordList;

    FinultimatePersistenceRemote dataServer = FinanceServiceLocator.locateFinancePersistenceManager();

    /**
     * Creates a new instance of CartItemBean
     */
    public CartItemBean() {
        posCartItem = new PosCartItem();
        posCartItemList = new ArrayList<PosCartItem>();
        posItemRecordList = new ArrayList<>();
    }

    @Override
    public List<PosCartItem> getCartItemEntitiesBetweenDates(Date startDate, Date endDate) throws ParseException {

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
            PosCartItem criteria = new PosCartItem();
            List<AbstractEntity> entityList = dataServer.findData(criteria, "SELECT i.* FROM pos_cart_item i, pos_transaction_records t, "
                    + "pos_cart_table c WHERE i.CART_ID = c.id AND c.id = t.CART_ID AND TIMESTAMP(t.TRANSACTION_DATE) >= TIMESTAMP('" + formatedStartDate + "') AND "
                    + "TIMESTAMP(t.TRANSACTION_DATE) <= TIMESTAMP('" + formatedEndDate + "')");

            for (AbstractEntity entity : entityList) {
                PosCartItem posCartItemEntity = (PosCartItem) entity;

                getPosCartItemList().add(posCartItemEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return posCartItemList;
    }

    @Override
    public List<PosItemRecord> getCartItemEntitiesBetweenDatesByUser(Date startDate, Date endDate, Long id) throws ParseException {
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
            List<AbstractEntity> entityList = dataServer.findData(criteria, "SELECT j.* FROM POS_ITEM_RECORD j WHERE j.id in (SELECT i.ITEM_ID FROM pos_cart_item i, pos_transaction_records t, \n"
                    + "pos_cart_table c WHERE i.CART_ID = c.id AND c.id = t.CART_ID AND TIMESTAMP(t.TRANSACTION_DATE) >= \n"
                    + "TIMESTAMP('" + formatedStartDate + "') AND \n"
                    + "TIMESTAMP(t.TRANSACTION_DATE) <= TIMESTAMP('" + formatedEndDate + "') AND t.TRANSACTION_USER = '" + id + "') ");

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
    public List<PosCartItem> getCartItemEntitiesBetweenDatesByCustomer(Date startDate, Date endDate, String id) throws ParseException {
        
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
            PosCartItem criteria = new PosCartItem();
            List<AbstractEntity> entityList = dataServer.findData(criteria, "SELECT i.* FROM pos_cart_item i, pos_transaction_records t, "
                    + "pos_cart_table c WHERE i.CART_ID = c.id AND c.id = t.CART_ID AND TIMESTAMP(t.TRANSACTION_DATE) >= TIMESTAMP('" + formatedStartDate + "') AND "
                    + "TIMESTAMP(t.TRANSACTION_DATE) <= TIMESTAMP('" + formatedEndDate + "') AND t.TRANSACTION_CUSTOMER = '" + id + "'");

            for (AbstractEntity entity : entityList) {
                PosCartItem posCartItemEntity = (PosCartItem) entity;

                getPosCartItemList().add(posCartItemEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return posCartItemList;
    }

    @Override
    public List<PosCartItem> getCartItemEntitiesBetweenDatesByOutlet(Date startDate, Date endDate, String outletName) throws ParseException {
        
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
            PosCartItem criteria = new PosCartItem();
            List<AbstractEntity> entityList = dataServer.findData(criteria, "SELECT i.* FROM pos_cart_item i, pos_transaction_records t, "
                    + "pos_cart_table c WHERE i.CART_ID = c.id AND c.id = t.CART_ID AND TIMESTAMP(t.TRANSACTION_DATE) >= TIMESTAMP('" + formatedStartDate + "') AND "
                    + "TIMESTAMP(t.TRANSACTION_DATE) <= TIMESTAMP('" + formatedEndDate + "') AND t.OUTLET_NAME = '" + outletName + "'");

            for (AbstractEntity entity : entityList) {
                PosCartItem posCartItemEntity = (PosCartItem) entity;

                getPosCartItemList().add(posCartItemEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return posCartItemList;
    }

    @Override
    public List<PosCartItem> getCartItemsByCartId(Long id) throws ParseException {
        try {
            PosCartItem criteria = new PosCartItem();
            List<AbstractEntity> entityList = dataServer.findData(criteria, "SELECT i.* FROM pos_cart_item i WHERE i.CART_ID ='" + id + "'");

            for (AbstractEntity entity : entityList) {
                PosCartItem posCartItemEntity = (PosCartItem) entity;

                getPosCartItemList().add(posCartItemEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return posCartItemList;
    }

    /**
     * @return the posCartItem
     */
    public PosCartItem getPosCartItem() {
        return posCartItem;
    }

    /**
     * @param posCartItem the posCartItem to set
     */
    public void setPosCartItem(PosCartItem posCartItem) {
        this.posCartItem = posCartItem;
    }

    /**
     * @return the posCartItemList
     */
    public List<PosCartItem> getPosCartItemList() {
        return posCartItemList;
    }

    /**
     * @param posCartItemList the posCartItemList to set
     */
    public void setPosCartItemList(List<PosCartItem> posCartItemList) {
        this.posCartItemList = posCartItemList;
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

}
