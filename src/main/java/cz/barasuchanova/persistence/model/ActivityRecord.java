package cz.barasuchanova.persistence.model;

import cz.barasuchanova.persistence.supportentity.ActivitySourceType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "activity_record")
public class ActivityRecord extends AbstractEntity
{
    Date started;
    Date ended;
    ActivitySourceType source;
    String note;

    @ManyToOne
    @JoinColumn(name = "child", referencedColumnName = "id")
    Child child;
}
