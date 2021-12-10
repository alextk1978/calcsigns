package ru.alextk.calcsigns.core.entity.sign.element;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.Hibernate;
import ru.alextk.calcsigns.core.entity.material.Material;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * @author Alexey Tkachenko
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "SIGN_ELEMENT")
@Inheritance(strategy = InheritanceType.JOINED)
public class SignElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Material> materials;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SignElement that = (SignElement) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
