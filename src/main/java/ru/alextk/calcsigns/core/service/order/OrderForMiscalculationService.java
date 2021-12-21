package ru.alextk.calcsigns.core.service.order;

import ru.alextk.calcsigns.core.entity.order.OrderForMiscalculation;
import ru.alextk.calcsigns.core.entity.sign.element.SignElement;

import java.util.Set;

/**
 * @author Alexey Tkachenko
 */
public interface OrderForMiscalculationService {
    OrderForMiscalculation save(OrderForMiscalculation orderForMiscalculation);

    void delete(OrderForMiscalculation orderForMiscalculation);

    OrderForMiscalculation findByOrderName(String name);

    OrderForMiscalculation create(String customer,
                                  String orderName,
                                  String deliveryAddress,
                                  Set<SignElement> signElements);
}
