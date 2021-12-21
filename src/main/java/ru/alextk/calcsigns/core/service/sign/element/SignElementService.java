package ru.alextk.calcsigns.core.service.sign.element;

import ru.alextk.calcsigns.core.entity.sign.element.SignElement;

/**
 * @author Alexey Tkachenko
 */
public interface SignElementService {

    SignElement save(SignElement signElement);

    void delete(SignElement signElement);
}
