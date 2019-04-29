package reporting.repository;

import reporting.domain.PosTransactionRecords;
import reporting.domain.PosUsersRecords;

import java.util.Date;
import java.util.List;

public interface PosUserRepository{
    
    public List<PosTransactionRecords> listPosUsers();
}
