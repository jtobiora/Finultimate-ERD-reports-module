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
import java.util.List;
import javax.faces.bean.ManagedBean;
import reporting.domain.PosCartItem;
import reporting.domain.Supplier;
import reporting.repository.SupplierRepository;

/**********START MAIN*************/
//@javax.faces.bean.SessionScoped
//@ManagedBean(name = "supplierBean")
//public class SupplierBean implements Serializable, SupplierRepository {
//    
//    private Supplier supplier;
//    
//    FinultimatePersistenceRemote dataServer = FinanceServiceLocator.locateFinancePersistenceManager();
//
//    /**
//     * Creates a new instance of SupplierBean
//     */
//    public SupplierBean() {
//        supplier = new Supplier();
//    }
//
//    @Override
//    public Supplier getSupplierById(String id) {
//        
//        try {
//            Supplier criteria = new Supplier();
//            List<AbstractEntity> entityList = dataServer.findData(criteria, "select Supplier.* from Supplier  where Supplier_Number = '"+ id +"'");
//
//            supplier = (Supplier)entityList.get(0);
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//
//        }
//        return supplier;
//    }
//
//    /**
//     * @return the supplier
//     */
//    public Supplier getSupplier() {
//        return supplier;
//    }
//
//    /**
//     * @param supplier the supplier to set
//     */
//    public void setSupplier(Supplier supplier) {
//        this.supplier = supplier;
//    }   
//}

/**********END MAIN*************/



//???????????????????????????????????????????????????? START NEW  ?????????????????????????????????????????????????????????????????????
@javax.faces.bean.SessionScoped
@ManagedBean(name = "supplierBean")
public class SupplierBean implements Serializable, SupplierRepository {
   private Supplier supplier;

   FinultimatePersistenceRemote dataServer = FinanceServiceLocator.locateFinancePersistenceManager();
   
    //Constructor
    public SupplierBean() {
       supplier = new Supplier();
    }
    
    
    @Override
    public Supplier getSupplierById(String id) {
        try {
            Supplier criteria = new Supplier();
            List<AbstractEntity> entityList =
                   dataServer.findData(criteria, "select Supplier.* from Supplier  where Supplier_Number = '"+ id +"'");

            supplier = (Supplier)entityList.get(0);

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return supplier;
    }


    public Supplier getSupplier() {
        return supplier;
    }


    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }   

}
//???????????????????????????????????????????????????? END NEW  ?????????????????????????????????????????????????????????????????????