package com.junction.natio.core.repository;


import com.junction.natio.core.model.SequenceEntity;

/**
 * Created by Anil Kumal on 02/02/2019.
 */
public interface ISequenceRepository extends ICrudRepository<SequenceEntity, Long> {
    SequenceEntity getByName(String name);
}
