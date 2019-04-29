package reporting.wrapper;

import reporting.domain.PosTransactionRecords;

/**
 * Created by israel on 5/5/17.
 */
public class TransactionWrapper {
    private PosTransactionRecords transaction;

    public PosTransactionRecords getTransaction() {
        return transaction;
    }

    public void setTransaction(PosTransactionRecords transaction) {
        this.transaction = transaction;
    }
}
