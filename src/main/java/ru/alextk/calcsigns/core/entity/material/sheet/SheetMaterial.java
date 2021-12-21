package ru.alextk.calcsigns.core.entity.material.sheet;

import lombok.*;
import ru.alextk.calcsigns.core.entity.material.Material;

import javax.persistence.*;

/**
 * Класс жестких листовых материалов использующихся в производстве рекламных вывесок со свойствами:
 * <b>nameOfMaterial </b>,<b>sheetDepth </b>,<b>sheetLength </b>,<b>sheetWidth </b>,<b>sheetPrice </b>,
 * <b>sheetSquare </b>,<b>pricePerSquareMillimeter</b>
 *
 * @author Alexey Tkachenko
 * @version 1.0.0
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "SHEET_MATERIAL")
public class SheetMaterial extends Material {

    /**
     * Толщина материала в мм.
     */
    @Column(name = "SHEET_DEPTH", nullable = false)
    private Integer sheetDepth;

    /**
     * Длина листа материала
     */
    @Column(name = "SHEET_LENGTH", nullable = false)
    private Integer sheetLength;

    /**
     * Ширина листа материала
     */
    @Column(name = "SHEET_WIDTH", nullable = false)
    private Integer sheetWidth;

    /**
     * Стоимость за лист в копейках
     */
    @Column(name = "SHEET_PRICE", nullable = false)
    private Integer sheetPrice;

    /**
     * Площадь листа материала в м2
     */
    @Column(name = "SHEET_SQUARE")
    private Float sheetSquare;

    /**
     * Стоимость 1 м2 материала
     */
    @Column(name = "PRICE_PER_SQUARE_MILLIMETER")
    private Integer pricePerSquareMillimeter;
}
