package reporting.repository;

import java.text.ParseException;
import reporting.domain.PosItemRecord;

import java.util.Date;
import java.util.List;

public interface ItemTableRepository {

    public List<PosItemRecord> getItemsBetweenDatesByProduct(Date startDate, Date endDate, Long pid) throws ParseException;

    public List<PosItemRecord> getItemsBetweenDatesByUser(Date startDate, Date endDate, Long uid) throws ParseException;
}
