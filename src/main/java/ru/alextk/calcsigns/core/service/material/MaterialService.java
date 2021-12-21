package ru.alextk.calcsigns.core.service.material;

import ru.alextk.calcsigns.core.entity.material.Material;

/**
 * @author Alexey Tkachenko
 */
public interface MaterialService {
    Material save(Material material);

    void delete(Material material);

    Material findByName(String nameOfMaterial);
}
