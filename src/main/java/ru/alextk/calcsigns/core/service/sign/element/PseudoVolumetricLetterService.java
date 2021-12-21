package ru.alextk.calcsigns.core.service.sign.element;

import ru.alextk.calcsigns.core.entity.sign.element.letter.Letter;

/**
 * @author Alexey Tkachenko
 */
public interface PseudoVolumetricLetterService extends SignElementService {
    Letter create(Integer height, Integer depth, String colour);
}

