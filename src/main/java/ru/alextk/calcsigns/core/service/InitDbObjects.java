package ru.alextk.calcsigns.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.alextk.calcsigns.core.entity.material.Material;
import ru.alextk.calcsigns.core.entity.material.sheet.SheetMaterial;
import ru.alextk.calcsigns.core.entity.material.vinyl.wrap.CommonVinylWrap;
import ru.alextk.calcsigns.core.entity.sign.element.letter.PseudoVolumetricLetter;
import ru.alextk.calcsigns.core.repository.*;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Alexey Tkachenko
 */
@Component
public class InitDbObjects {

    private final MaterialRepository materialRepository;
    private final SignElementRepository signElementRepository;

    @Autowired
    public InitDbObjects(MaterialRepository materialRepository, SignElementRepository signElementRepository) {
        this.materialRepository = materialRepository;
        this.signElementRepository = signElementRepository;
    }

    @Bean
    public PseudoVolumetricLetter pseudoVolumetricLetter() {

        SheetMaterial sheetMaterial = SheetMaterial.createSheetMaterial(
                "PVC",
                10,
                203,
                305,
                305000);

        SheetMaterial sheetMaterial1 = SheetMaterial.createSheetMaterial(
                "ACP",
                3,
                150,
                400,
                980000);

        CommonVinylWrap commonVinylWrap = CommonVinylWrap.createCommonVinylWrap(
                "Oracal",
                "641",
                "070M",
                126,
                21300
        );

        CommonVinylWrap commonVinylWrap1 = CommonVinylWrap.createCommonVinylWrap(
                "Oracal",
                "641",
                "032",
                100,
                19600
        );

        Set<Material> materialSet = new HashSet<>();

        materialSet.add(sheetMaterial);
        materialSet.add(commonVinylWrap);

        materialRepository.save(sheetMaterial);
        materialRepository.save(commonVinylWrap);
        materialRepository.save(sheetMaterial1);
        materialRepository.save(commonVinylWrap1);

        PseudoVolumetricLetter pseudoVolumetricLetter = PseudoVolumetricLetter.createPseudoVolumetricLetter(
                40,
                materialSet
        );

        PseudoVolumetricLetter pseudoVolumetricLetter1 = PseudoVolumetricLetter.createPseudoVolumetricLetter(
                50,
                materialSet
        );

        signElementRepository.save(pseudoVolumetricLetter);

        pseudoVolumetricLetter1.getMaterials().add(commonVinylWrap1);
        pseudoVolumetricLetter1.getMaterials().add(sheetMaterial1);

        return signElementRepository.save(pseudoVolumetricLetter1);
    }
}
