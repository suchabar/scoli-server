package cz.barasuchanova.persistence.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "wearing_record")
public class WearingRecord extends AbstractEntity
{
    Date started;
    Date ended;

    @ManyToOne
    @JoinColumn(name = "brace", referencedColumnName = "id")
    Brace brace;
}
