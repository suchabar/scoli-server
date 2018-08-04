package cz.barasuchanova.persistence.model;

import cz.barasuchanova.persistence.supportentity.SpineType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.awt.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "spine_record")
public class SpineRecord extends AbstractEntity
{
    String radiographUrl;

    Boolean braceOn;

    SpineType spineType;

    Float angle;

    Float angle2;

    @ManyToOne
    @JoinColumn(name = "medicalCheckup", referencedColumnName = "id")
    MedicalCheckup medicalCheckup;
}
