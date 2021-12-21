package ru.alextk.calcsigns.core.repository.material;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.alextk.calcsigns.core.entity.material.Material;
import ru.alextk.calcsigns.core.entity.material.vinyl.wrap.CommonVinylWrap;

/**
 * @author Alexey Tkachenko
 */
public interface CommonVinylWrapRepository extends MaterialRepository {

    @Query("SELECT v FROM CommonVinylWrap v WHERE v.nameOfManufacturer = :name")
    Material findMaterialByNameOfManufacturer(@Param("name") String name);

    @Query("SELECT v FROM CommonVinylWrap v WHERE v.colour = :colour")
    Material findMaterialByColour(@Param("colour") String colour);

    @Query("SELECT v FROM CommonVinylWrap v WHERE v.series = :series")
    Material findMaterialBySeries(@Param("series") String series);

    @Query("SELECT v FROM CommonVinylWrap v WHERE v.rollWidth = :width")
    Material findMaterialByRollWidth(@Param("width") Integer width);

    @Query("SELECT v FROM CommonVinylWrap v WHERE v.series = :series AND v.colour = :colour")
    CommonVinylWrap findMaterialBySeriesAndColour(@Param("series") String series, @Param("colour") String colour);
}
