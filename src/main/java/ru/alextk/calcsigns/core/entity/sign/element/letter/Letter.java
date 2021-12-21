package ru.alextk.calcsigns.core.entity.sign.element.letter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.alextk.calcsigns.core.entity.sign.element.SignElement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Alexey Tkachenko
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "LETTERS")
public class Letter extends SignElement {

    @Column(name = "HEIGHT", nullable = false)
    private Integer height;

    @Column(name = "depth")
    private Integer depth;

    @Column(name = "square")
    private Integer square;

    @Column(name = "colour")
    private String colour;

    @Column(name = "unit_prime_price")
    private Integer unitPrimePrice;

    @Column(name = "unit_selling_price")
    private Integer unitSellingPrice;
}
