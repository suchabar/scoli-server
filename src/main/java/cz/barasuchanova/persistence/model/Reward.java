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
@Table(name = "reward")
public class Reward extends AbstractEntity
{
    Date datePurchased;

    @ManyToOne
    @JoinColumn(name = "child", referencedColumnName = "id")
    Child child;

    @ManyToOne
    @JoinColumn(name = "store_item", referencedColumnName = "id")
    StoreItem storeItem;
}
