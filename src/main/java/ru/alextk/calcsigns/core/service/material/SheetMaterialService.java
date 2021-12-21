package ru.alextk.calcsigns.core.service.material;

import ru.alextk.calcsigns.core.entity.material.Material;
import ru.alextk.calcsigns.core.entity.material.sheet.SheetMaterial;

/**
 * @author Alexey Tkachenko
 */
public interface SheetMaterialService extends MaterialService {

    Material create(String nameOfMaterial,
                    Integer sheetDepth,
                    Integer sheetLength,
                    Integer sheetWidth,
                    Integer sheetPrice);

    SheetMaterial findMaterialBySheetDepth(Integer depth);
}
