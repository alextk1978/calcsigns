package ru.alextk.calcsigns.core.service.material;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alextk.calcsigns.core.entity.material.Material;
import ru.alextk.calcsigns.core.entity.material.vinyl.wrap.CommonVinylWrap;
import ru.alextk.calcsigns.core.repository.material.CommonVinylWrapRepository;

/**
 * @author Alexey Tkachenko
 */

@Service
public class CommonVinylWrapServiceImpl implements CommonVinylWrapService {

    private final CommonVinylWrapRepository commonVinylWrapRepository;

    @Autowired
    public CommonVinylWrapServiceImpl(CommonVinylWrapRepository commonVinylWrapRepository) {
        this.commonVinylWrapRepository = commonVinylWrapRepository;
    }

    @Override
    public CommonVinylWrap create(@NonNull String nameOfManufacturer,
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
    @Transactional(readOnly = true)
    public Material findMaterialByNameOfManufacturer(String name) {
        return commonVinylWrapRepository.findMaterialByNameOfManufacturer(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Material findMaterialByColour(String colour) {
        return commonVinylWrapRepository.findMaterialByColour(colour);
    }

    @Override
    @Transactional(readOnly = true)
    public Material findMaterialBySeries(String series) {
        return commonVinylWrapRepository.findMaterialBySeries(series);
    }

    @Override
    @Transactional(readOnly = true)
    public Material findMaterialByRollWidth(Integer width) {
        return commonVinylWrapRepository.findMaterialByRollWidth(width);
    }

    @Override
    @Transactional(readOnly = true)
    public CommonVinylWrap findMaterialBySeriesAndColour(String series, String colour) {
        return commonVinylWrapRepository.findMaterialBySeriesAndColour(series, colour);
    }

    @Override
    @Transactional
    public Material save(Material material) {
        return commonVinylWrapRepository.save(material);
    }

    @Override
    @Transactional
    public void delete(Material material) {
        commonVinylWrapRepository.delete(material);
    }

    @Override
    @Transactional(readOnly = true)
    public Material findByName(String nameOfMaterial) {
        return commonVinylWrapRepository.findMaterialByNameOfMaterial(nameOfMaterial);
    }
}
