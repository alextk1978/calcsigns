package ru.alextk.calcsigns.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alextk.calcsigns.core.entity.sign.element.SignElement;

/**
 * @author Alexey Tkachenko
 */
public interface SignElementRepository extends JpaRepository<SignElement, Long> {
}
