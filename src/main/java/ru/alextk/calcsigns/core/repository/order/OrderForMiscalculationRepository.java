package ru.alextk.calcsigns.core.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alextk.calcsigns.core.entity.order.OrderForMiscalculation;

/**
 * @author Alexey Tkachenko
 */
public interface OrderForMiscalculationRepository extends JpaRepository<OrderForMiscalculation, Long> {
    OrderForMiscalculation findOrderForMiscalculationByOrderName(String name);
}
