package ru.alextk.calcsigns.core.service.sign.element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alextk.calcsigns.core.entity.material.Material;
import ru.alextk.calcsigns.core.entity.material.sheet.SheetMaterial;
import ru.alextk.calcsigns.core.entity.material.vinyl.wrap.CommonVinylWrap;
import ru.alextk.calcsigns.core.entity.sign.element.SignElement;
import ru.alextk.calcsigns.core.entity.sign.element.letter.Letter;
import ru.alextk.calcsigns.core.entity.sign.element.letter.PseudoVolumetricLetter;
import ru.alextk.calcsigns.core.repository.sign.SignElementRepository;
import ru.alextk.calcsigns.core.service.material.CommonVinylWrapService;
import ru.alextk.calcsigns.core.service.material.SheetMaterialService;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Alexey Tkachenko
 */
@Service
public class PseudoVolumetricLetterServiceImpl implements PseudoVolumetricLetterService {
    private final SignElementRepository signElementRepository;
    private final SheetMaterialService sheetMaterialService;
    private final CommonVinylWrapService commonVinylWrapService;

    @Autowired
    public PseudoVolumetricLetterServiceImpl(SignElementRepository signElementRepository, SheetMaterialService sheetMaterialService, CommonVinylWrapService commonVinylWrapService) {
        this.signElementRepository = signElementRepository;
        this.sheetMaterialService = sheetMaterialService;
        this.commonVinylWrapService = commonVinylWrapService;
    }

    @Override
    @Transactional
    public SignElement save(SignElement signElement) {
        return signElementRepository.save(signElement);
    }

    @Override
    @Transactional
    public void delete(SignElement signElement) {
        signElementRepository.delete(signElement);
    }

    @Override
    @Transactional(readOnly = true)
    public Letter create(Integer height, Integer depth, String colour) {
        Letter letter = new PseudoVolumetricLetter();

        letter.setHeight(height);
        letter.setDepth(depth);
        letter.setColour(colour);
        letter.setItemName("Псевдообъемная буква");

        SheetMaterial baseMaterial = sheetMaterialService.findMaterialBySheetDepth(depth);
        CommonVinylWrap faceWrap = commonVinylWrapService.findMaterialBySeriesAndColour("641", colour);

        letter.setSquare(height * height);

        letter.setUnitPrimePrice(((baseMaterial.getPricePerSquareMillimeter() + faceWrap.getPricePerSquareMeter()) *
                letter.getSquare()) / letter.getHeight());

        letter.setUnitSellingPrice(letter.getUnitPrimePrice() * 50);

        letter.setPriceForTheWholeProduct(letter.getUnitSellingPrice() * letter.getHeight());

        Set<Material> materialSet = new HashSet<>();

        materialSet.add(baseMaterial);
        materialSet.add(faceWrap);

        letter.setMaterials(materialSet);
        return letter;
    }
}
