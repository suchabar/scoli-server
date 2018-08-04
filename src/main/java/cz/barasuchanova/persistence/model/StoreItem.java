package cz.barasuchanova.persistence.model;

import cz.barasuchanova.persistence.supportentity.SpineType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.awt.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "store_item")
public class StoreItem extends AbstractEntity
{
    String title;
    String pictureUrl;
    Integer price;
    String note;
}
