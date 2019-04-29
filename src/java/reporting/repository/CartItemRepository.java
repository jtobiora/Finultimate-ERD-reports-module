package reporting.repository;

import reporting.domain.PosCartItem;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import reporting.domain.PosItemRecord;

public interface CartItemRepository {

    public List<PosCartItem> getCartItemEntitiesBetweenDates(Date startDate, Date endDate) throws ParseException;

    public List<PosItemRecord> getCartItemEntitiesBetweenDatesByUser( Date startDate, Date endDate, Long id)throws ParseException;

    public List<PosCartItem> getCartItemEntitiesBetweenDatesByCustomer(Date startDate, Date endDate, String id)throws ParseException;

    public List<PosCartItem> getCartItemEntitiesBetweenDatesByOutlet( Date startDate, Date endDate, String outletName)throws ParseException;

    public List<PosCartItem> getCartItemsByCartId(Long id)throws ParseException;

}
