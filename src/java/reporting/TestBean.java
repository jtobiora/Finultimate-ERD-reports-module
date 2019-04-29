/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting;

import com.rsdynamics.projects.eao.FinultimatePersistenceRemote;
import com.rsdynamix.abstractobjects.AbstractEntity;
import com.rsdynamix.projects.binding.FinanceServiceLocator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import reporting.domain.PosCartItem;

/**
 *
 * @author S3-Developer
 */
@javax.faces.bean.SessionScoped
@ManagedBean(name = "testBean")
public class TestBean implements Serializable {
 
    private PosCartItem posCartItem ;
    private List<PosCartItem> posCartItemList ;
    
    /**
     * Creates a new instance of TestBean
     */
    public TestBean() {
        posCartItem = new PosCartItem();
        posCartItemList = new ArrayList<>();
        
        CartItems();
    }
    
    public void CartItems(){
        FinultimatePersistenceRemote dataServer = FinanceServiceLocator.locateFinancePersistenceManager();
        
        try {
            PosCartItem criteria = new PosCartItem();
            List<AbstractEntity> entityList = dataServer.findData(criteria,"SELECT  FROM PosCartItem i WHERE i.cartId.id =:id");

            for (AbstractEntity entity : entityList) {
                PosCartItem posCartItemEntity = (PosCartItem) entity;
                posCartItemList.add(posCartItemEntity);

                System.out.println(posCartItemEntity.getItemCostPRice());
            }
                      
        } catch (Exception ex) {
            ex.printStackTrace();
            
        }
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
    
}
