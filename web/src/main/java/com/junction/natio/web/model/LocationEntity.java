package com.junction.natio.web.model;

import com.junction.natio.core.model.EntityBase;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "location")
public class LocationEntity extends EntityBase {



}
