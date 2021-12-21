package ru.alextk.calcsigns.core.entity.order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import ru.alextk.calcsigns.core.entity.sign.element.SignElement;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Alexey Tkachenko
 *
 * Класс, описывающий сущность Заказ на просчет стоимости.
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ESTIMATES")
public class OrderForMiscalculation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Заказчик
     */
    @Column (name = "clients")
    private String customer;

    /**
     * Наименование заказа
     */
    @Column(name = "order_names")
    private String orderName;

    /**
     * Адрес доставки
     */
    @Column(name = "delivery_addresses")
    private String deliveryAddress;

    /**
     * Общая стоимость заказа
     */
    @Column(name = "total_costs")
    private Integer totalCost;

    /**
     * Коллекция элементов, из которых формируется заказ
     */
    @JsonBackReference
    @ToString.Exclude
    @Column(name = "sign_elements")
    @OneToMany
    private Set<SignElement> signElements;

}
