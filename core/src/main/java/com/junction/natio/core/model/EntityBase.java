package com.junction.natio.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**

 */
@Getter
@Setter
@MappedSuperclass
public class EntityBase extends ModelBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Version
    @Column(name = "version")
    private Long version = 0L;


}
