package reporting.repository;

import reporting.domain.PosCartTable;


import java.util.Date;
import java.util.List;

public interface CartRepository {

    //@Query("SELECT c FROM PosCartTable c WHERE c.posTransactionRecords.transactionDate BETWEEN :startDate AND :endDate")
    //public List<PosCartTable> getCartEntitiesBetweenDates(@Param("startDate")Date startDate, @Param("endDate")Date endDate);

    //@Query("SELECT c FROM PosCartTable c WHERE c.posTransactionRecords.id = :id")
    //public List<PosCartTable> getCartByTransactionId(@Param("id")Long id);

    //@Query("SELECT c FROM PosCartTable c, PosTransactionRecords t WHERE t.cartId.id = c.id AND t.transactionDate BETWEEN :startDate AND :endDate")
    //public List<PosCartTable> getCartEntitiesBetweenDates(@Param("startDate")Date startDate, @Param("endDate")Date endDate);


    //Find CartItem by Cart_id

    //Find Sum Item Count by cart_id

    //Find sum revenue by cart_id



}
