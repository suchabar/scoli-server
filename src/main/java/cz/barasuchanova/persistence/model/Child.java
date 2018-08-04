package cz.barasuchanova.persistence.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "child")
public class Child extends AbstractEntity
{
    String nickname;
    String email;
    String password;
    String avatarUrl;
    Integer points;

    @OneToMany(mappedBy = "child", fetch = FetchType.LAZY)
    List<MedicalCheckup> medicalCheckups;

    @OneToMany(mappedBy = "child", fetch = FetchType.LAZY)
    List<Brace> braces;

    @OneToMany(mappedBy = "child", fetch = FetchType.LAZY)
    List<ActivityRecord> activityRecords;

    @OneToMany(mappedBy = "child", fetch = FetchType.LAZY)
    List<Reward> rewards;
}
