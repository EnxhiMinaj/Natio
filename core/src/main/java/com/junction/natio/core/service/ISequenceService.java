package com.junction.natio.core.service;


import com.junction.natio.core.model.SequenceEntity;

/**
 * Created by Admin on 02/02/2019.
 */
public interface ISequenceService extends ICrudService<SequenceEntity, String> {
    SequenceEntity getByName(String name);
}
