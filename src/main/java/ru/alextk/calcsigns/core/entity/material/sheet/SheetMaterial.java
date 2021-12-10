package ru.alextk.calcsigns.core.entity.material.sheet;

import lombok.*;
import org.jetbrains.annotations.NotNull;
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
     * Наименование материала. Например "Вспененный ПВХ-пластик"
     */
    @Column(name = "NAME_OF_MATERIAL", nullable = false)
    private String nameOfMaterial;

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

    /**
     * Метод для создания нового объекта с определенными значениями.
     *
     * @param nameOfMaterial наименование материала
     * @param sheetDepth     толщина материала в мм
     * @param sheetLength    длина листа
     * @param sheetWidth     ширина листа
     * @param sheetPrice     стоимость за лист
     */
    public static @NotNull SheetMaterial createSheetMaterial(@NonNull String nameOfMaterial,
                                                             @NonNull Integer sheetDepth,
                                                             @NonNull Integer sheetLength,
                                                             @NonNull Integer sheetWidth,
                                                             @NonNull Integer sheetPrice) {
        SheetMaterial sheetMaterial = new SheetMaterial();
        sheetMaterial.setNameOfMaterial(nameOfMaterial);
        sheetMaterial.setSheetDepth(sheetDepth);
        sheetMaterial.setSheetLength(sheetLength);
        sheetMaterial.setSheetWidth(sheetWidth);
        sheetMaterial.setSheetPrice(sheetPrice);
        sheetMaterial.setSheetSquare((float) sheetLength * sheetWidth);
        sheetMaterial.setPricePerSquareMillimeter((int) (sheetMaterial.getSheetPrice() / sheetMaterial.getSheetSquare()));
        return sheetMaterial;
    }
}
