package cz.barasuchanova.persistence.supportentity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public enum ActivitySourceType
{
    ACTIBELT, GOOGLE_FIT, XIAOMI_BAND, MANUAL_ENTRY;
}