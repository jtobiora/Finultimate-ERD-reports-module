package reporting.repository;

import java.text.ParseException;
import reporting.domain.PosTransactionRecords;

import java.util.Date;
import java.util.List;
import reporting.domain.PosCartTable;

public interface TransactionRepository{
  
    public List<PosCartTable> getTransactionsBetweenDates(Date startDate, Date endDate) throws ParseException;

    public List<PosCartTable> getTransactionsBetweenDatesByUser(Date startDate, Date endDate, Long userId) throws ParseException;

    public List<PosCartTable> getTransactionsBetweenDatesByOutlet(Date startDate, Date endDate, String outletName) throws ParseException;

    public List<String> getOutletsBetweenDates(Date startDate,Date endDate) throws ParseException;

    public List<PosCartTable> getTransactionsBetweenDatesByCustomer(Date startDate, Date endDate, String customerId) throws ParseException;

    public List<PosTransactionRecords> getTransactionsBetweenDatesByProduct(Date startDate, Date endDate, Long pid) throws ParseException;

    public List<PosTransactionRecords> getTransactionsBetweenDatesByProductAndUser(Date startDate, Date endDate, Long pid, Long userId) throws ParseException;

}
