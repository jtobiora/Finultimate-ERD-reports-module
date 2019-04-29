package reporting.repository;

import java.text.ParseException;
import reporting.domain.PosCustomerRecords;

import java.util.Date;
import java.util.List;

public interface CustomerRepository {
    
    public PosCustomerRecords findByClientId(String clientId);

}
