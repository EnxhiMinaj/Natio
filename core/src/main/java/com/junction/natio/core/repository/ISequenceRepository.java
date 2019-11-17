package com.junction.natio.core.repository;


import com.junction.natio.core.model.SequenceEntity;

/**

 */
public interface ISequenceRepository extends ICrudRepository<SequenceEntity, Long> {
    SequenceEntity getByName(String name);
}
