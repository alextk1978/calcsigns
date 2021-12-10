package ru.alextk.calcsigns.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alextk.calcsigns.core.entity.material.Material;

/**
 * @author Alexey Tkachenko
 */
public interface MaterialRepository extends JpaRepository<Material, Long> {
}
