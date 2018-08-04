package cz.barasuchanova.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public interface IEntity extends Serializable {

    @JsonIgnore
    Integer getId();

    @JsonIgnore
    void setId(Integer id);

}
