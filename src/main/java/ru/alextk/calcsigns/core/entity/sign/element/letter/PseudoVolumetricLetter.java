package ru.alextk.calcsigns.core.entity.sign.element.letter;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import ru.alextk.calcsigns.core.entity.material.Material;
import ru.alextk.calcsigns.core.entity.sign.element.SignElement;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Alexey Tkachenko
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PSEUDO_VOLUMETRIC_LETTERS")
public class PseudoVolumetricLetter extends SignElement implements Letter {

    @Column(name = "HEIGHT", nullable = false)
    private Integer height;

    public static @NotNull PseudoVolumetricLetter createPseudoVolumetricLetter(Integer height, Set<Material> materialSet) {
        var pseudoVolumetricLetter = new PseudoVolumetricLetter();
        pseudoVolumetricLetter.setHeight(height);
        pseudoVolumetricLetter.setMaterials(materialSet);
        return pseudoVolumetricLetter;
    }
}
