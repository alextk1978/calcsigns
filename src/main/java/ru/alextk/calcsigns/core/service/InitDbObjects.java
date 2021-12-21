package ru.alextk.calcsigns.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.alextk.calcsigns.core.entity.material.sheet.SheetMaterial;
import ru.alextk.calcsigns.core.entity.material.vinyl.wrap.CommonVinylWrap;
import ru.alextk.calcsigns.core.entity.order.OrderForMiscalculation;
import ru.alextk.calcsigns.core.entity.sign.element.SignElement;
import ru.alextk.calcsigns.core.repository.material.MaterialRepository;
import ru.alextk.calcsigns.core.repository.order.OrderForMiscalculationRepository;
import ru.alextk.calcsigns.core.repository.sign.SignElementRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Alexey Tkachenko
 */
@Component
public class InitDbObjects {

    private final MaterialRepository materialRepository;
    private final SignElementRepository signElementRepository;
    private final OrderForMiscalculationRepository orderForMiscalculationRepository;

    @Autowired
    public InitDbObjects(MaterialRepository materialRepository, SignElementRepository signElementRepository, OrderForMiscalculationRepository orderForMiscalculationRepository) {
        this.materialRepository = materialRepository;
        this.signElementRepository = signElementRepository;
        this.orderForMiscalculationRepository = orderForMiscalculationRepository;
    }

    @Bean
    public OrderForMiscalculation orderForMiscalculation() {



        return null;
    }
}
