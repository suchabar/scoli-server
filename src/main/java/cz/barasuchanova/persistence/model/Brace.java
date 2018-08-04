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
@Table(name = "brace")
public class Brace extends AbstractEntity
{
    String name;
    String photoUrl;
    Date wearingFrom;
    Date wearingTo;
    Integer recommendedWearingTime;

    @ManyToOne
    @JoinColumn(name = "child", referencedColumnName = "id")
    Child child;

    @OneToMany(mappedBy = "brace", fetch = FetchType.LAZY)
    List<WearingRecord> wearingRecords;
}
