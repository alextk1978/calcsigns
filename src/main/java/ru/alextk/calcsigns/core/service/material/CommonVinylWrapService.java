package ru.alextk.calcsigns.core.service.material;

import ru.alextk.calcsigns.core.entity.material.Material;
import ru.alextk.calcsigns.core.entity.material.vinyl.wrap.CommonVinylWrap;

/**
 * @author Alexey Tkachenko
 */
public interface CommonVinylWrapService extends MaterialService {

    Material create(String nameOfManufacturer,
                    String series,
                    String colour,
                    Integer rollWidth,
                    Integer pricePerRunningMeter);

    Material findMaterialByNameOfManufacturer(String name);

    Material findMaterialByColour(String colour);

    Material findMaterialBySeries(String series);

    Material findMaterialByRollWidth(Integer width);

    CommonVinylWrap findMaterialBySeriesAndColour(String series, String colour);
}
