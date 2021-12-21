package ru.alextk.calcsigns.core.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alextk.calcsigns.core.entity.order.OrderForMiscalculation;
import ru.alextk.calcsigns.core.entity.sign.element.SignElement;
import ru.alextk.calcsigns.core.repository.order.OrderForMiscalculationRepository;

import java.util.Set;

/**
 * @author Alexey Tkachenko
 */
@Service
public class OrderForMiscalculationServiceImpl implements OrderForMiscalculationService {
    private final OrderForMiscalculationRepository orderForMiscalculationRepository;

    @Autowired
    public OrderForMiscalculationServiceImpl(OrderForMiscalculationRepository orderForMiscalculationRepository) {
        this.orderForMiscalculationRepository = orderForMiscalculationRepository;
    }

    @Override
    @Transactional
    public OrderForMiscalculation save(OrderForMiscalculation orderForMiscalculation) {
        return orderForMiscalculationRepository.save(orderForMiscalculation);
    }

    @Override
    @Transactional
    public void delete(OrderForMiscalculation orderForMiscalculation) {
        orderForMiscalculationRepository.delete(orderForMiscalculation);
    }

    @Override
    @Transactional(readOnly = true)
    public OrderForMiscalculation findByOrderName(String name) {
        return orderForMiscalculationRepository.findOrderForMiscalculationByOrderName(name);
    }

    @Override
    public OrderForMiscalculation create(String customer,
                                         String orderName,
                                         String deliveryAddress,
                                         Set<SignElement> signElements) {

        OrderForMiscalculation orderForMiscalculation = new OrderForMiscalculation();
        orderForMiscalculation.setCustomer(customer);
        orderForMiscalculation.setOrderName(orderName);
        orderForMiscalculation.setDeliveryAddress(deliveryAddress);
        orderForMiscalculation.setSignElements(signElements);

        Integer sum = 0;

        for (SignElement signElement : signElements) {
            sum += signElement.getPriceForTheWholeProduct();
        }

        orderForMiscalculation.setTotalCost(sum);

        return orderForMiscalculation;
    }
}
