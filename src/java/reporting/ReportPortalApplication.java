package reporting;

import com.rsdynamics.projects.eao.FinultimatePersistenceRemote;
import com.rsdynamix.abstractobjects.AbstractEntity;
import com.rsdynamix.projects.binding.FinanceServiceLocator;
import java.util.ArrayList;
import java.util.List;
import reporting.domain.PosCartItem;


public class ReportPortalApplication {
    private static PosCartItem posCartItem = new PosCartItem();
    private static List<PosCartItem> posCartItemList = new ArrayList<>();   
    private static FinultimatePersistenceRemote dataServer = FinanceServiceLocator.locateFinancePersistenceManager();
    
    public static void main(String[] args) {
        
    }
}
