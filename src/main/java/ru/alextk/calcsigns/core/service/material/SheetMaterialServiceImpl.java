package ru.alextk.calcsigns.core.service.material;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alextk.calcsigns.core.entity.material.Material;
import ru.alextk.calcsigns.core.entity.material.sheet.SheetMaterial;
import ru.alextk.calcsigns.core.repository.material.SheetMaterialRepository;

/**
 * @author Alexey Tkachenko
 */
@Service
public class SheetMaterialServiceImpl implements SheetMaterialService {
    private final SheetMaterialRepository sheetMaterialRepository;

    @Autowired
    public SheetMaterialServiceImpl(SheetMaterialRepository sheetMaterialRepository) {
        this.sheetMaterialRepository = sheetMaterialRepository;
    }

    @Override
    @Transactional
    public Material create(@NonNull String nameOfMaterial,
                           @NonNull Integer sheetDepth,
                           @NonNull Integer sheetLength,
                           @NonNull Integer sheetWidth,
                           @NonNull Integer sheetPrice) {

        var sheetMaterial = new SheetMaterial();
        sheetMaterial.setNameOfMaterial(nameOfMaterial);
        sheetMaterial.setSheetDepth(sheetDepth);
        sheetMaterial.setSheetLength(sheetLength);
        sheetMaterial.setSheetWidth(sheetWidth);
        sheetMaterial.setSheetPrice(sheetPrice);
        sheetMaterial.setSheetSquare((float) sheetLength * sheetWidth);
        sheetMaterial.setPricePerSquareMillimeter((int) (sheetMaterial.getSheetPrice() / sheetMaterial.getSheetSquare()));
        return sheetMaterial;
    }

    @Override
    public SheetMaterial findMaterialBySheetDepth(Integer depth) {
        return sheetMaterialRepository.findMaterialBySheetDepth(depth);
    }

    @Override
    @Transactional
    public Material save(Material material) {
        return sheetMaterialRepository.save(material);
    }

    @Override
    @Transactional
    public void delete(Material material) {
        sheetMaterialRepository.delete(material);
    }

    @Override
    @Transactional(readOnly = true)
    public Material findByName(String nameOfMaterial) {
        return sheetMaterialRepository.findMaterialByNameOfMaterial(nameOfMaterial);
    }
}
