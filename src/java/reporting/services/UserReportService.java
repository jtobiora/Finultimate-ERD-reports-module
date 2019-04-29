package reporting.services;

import reporting.domain.PosItemRecord;

import java.util.Date;
import java.util.List;

/**
 * Created by israel on 5/12/17.
 */
public interface UserReportService {

    List<PosItemRecord> selectDistinctItemsByUser(Long userId, Date startDate, Date endDate);

}
