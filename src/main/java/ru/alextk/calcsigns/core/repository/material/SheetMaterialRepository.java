package ru.alextk.calcsigns.core.repository.material;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.alextk.calcsigns.core.entity.material.sheet.SheetMaterial;

/**
 * @author Alexey Tkachenko
 */
public interface SheetMaterialRepository extends MaterialRepository {

    @Query("SELECT m FROM SheetMaterial m WHERE m.sheetDepth = :depth")
    SheetMaterial findMaterialBySheetDepth(@Param("depth") Integer depth);
}
