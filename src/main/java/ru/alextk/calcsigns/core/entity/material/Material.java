package ru.alextk.calcsigns.core.entity.material;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.Hibernate;
import ru.alextk.calcsigns.core.entity.sign.element.SignElement;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * @author Alexey Tkachenko
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MATERIAL")
@Inheritance(strategy = InheritanceType.JOINED)
public class Material {

    /**
     * Уникальный идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Наименование материала. Например "Вспененный ПВХ-пластик"
     */

    @Column(name = "name_of_materials")
    private String nameOfMaterial;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<SignElement> signElements;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Material material = (Material) o;
        return id != null && Objects.equals(id, material.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
