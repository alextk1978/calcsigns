package ru.alextk.calcsigns.core.entity.material.vinyl.wrap;

import lombok.*;
import org.hibernate.Hibernate;
import org.jetbrains.annotations.NotNull;
import ru.alextk.calcsigns.core.entity.material.Material;

import javax.persistence.*;
import java.util.Objects;

/**
 * Класс обычных (несветовых) виниловых пленок, использующихся в производстве рекламных вывесок
 *
 * @author Alexey Tkachenko
 * @version 1.0.0
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "COMMON_VINYL_WRAP")
public class CommonVinylWrap extends Material {

    /**
     * Название производителя пленки.
     */
    @Column(name = "NAME_OF_MANUFACTURER", nullable = false)
    private String nameOfManufacturer;

    /**
     * Серия пленки
     */
    @Column(name = "SERIES", nullable = false)
    private String series;

    /**
     * Цвет пленки
     */
    @Column(name = "COLOUR", nullable = false)
    private String colour;

    /**
     * Ширина рулона
     */
    @Column(name = "ROLL_WIDTH", nullable = false)
    private Integer rollWidth;

    /**
     * Цена за погонный метр
     */
    @Column(name = "PRICE_PER_RUNNING_METER")
    private Integer pricePerRunningMeter;

    @JoinColumn(name = "PRICE_PER_SQUARE_METER")
    private Integer pricePerSquareMeter;

    public static @NotNull CommonVinylWrap createCommonVinylWrap(@NonNull String nameOfManufacturer,
                                                                 @NonNull String series,
                                                                 @NonNull String colour,
                                                                 @NonNull Integer rollWidth,
                                                                 @NonNull Integer pricePerRunningMeter) {
        var commonVinylWrap = new CommonVinylWrap();
        commonVinylWrap.setNameOfManufacturer(nameOfManufacturer);
        commonVinylWrap.setSeries(series);
        commonVinylWrap.setColour(colour);
        commonVinylWrap.setRollWidth(rollWidth);
        commonVinylWrap.setPricePerRunningMeter(pricePerRunningMeter);
        commonVinylWrap.setPricePerSquareMeter(commonVinylWrap.getPricePerRunningMeter() / commonVinylWrap.getRollWidth());
        return commonVinylWrap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        var that = (CommonVinylWrap) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
