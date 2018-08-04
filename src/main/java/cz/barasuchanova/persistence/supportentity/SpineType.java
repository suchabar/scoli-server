package cz.barasuchanova.persistence.supportentity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public enum SpineType
{
    LORDOSIS, KYPHOSIS, SCOLIOSIS, THOROCOLUMBAR_LEFT, THOROCOLUMBAR_RIGH, LUMBAR_LEFT, LUMBAR_RIGHT, THORACIC_LEFT,
    THORARIC_RIGHT, DOUBLE_MAJOR_RIGHT_LEFT, DOUBLE_MAJOR_LEFT_RIGH
}