/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import reporting.domain.PosItemRecord;
import reporting.services.UserReportService;

/**
 *
 * @author S3-Developer
 */
@javax.faces.bean.SessionScoped
@ManagedBean(name = "salesUserReportBean")
public class SalesUserReportBean implements Serializable,UserReportService {

    /**
     * Creates a new instance of SalesUserReportBean
     */
    public SalesUserReportBean() {
    }

    @Override
    public List<PosItemRecord> selectDistinctItemsByUser(Long userId, Date startDate, Date endDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
