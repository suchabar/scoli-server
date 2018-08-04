package cz.barasuchanova.persistence.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "medical_checkup")
public class MedicalCheckup extends AbstractEntity
{
    Date date;
    Float height;
    Float weight;

    @ManyToOne
    @JoinColumn(name = "child", referencedColumnName = "id")
    Child child;

    @OneToMany(mappedBy = "medicalCheckup", fetch = FetchType.LAZY)
    List<SpineRecord> spineRecords;
}
