package com.junction.natio.core.repository.impl;

import com.junction.natio.core.model.GlobalSettingEntity;
import com.junction.natio.core.repository.IGlobalSettingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Anil Kumal on 30/11/2018.
 */
@Repository
public class GlobalSettingRepositoryImpl extends CrudRepositoryImpl<GlobalSettingEntity, Long> implements IGlobalSettingRepository {
    public GlobalSettingRepositoryImpl() {
        super(GlobalSettingEntity.class);
    }


    @Override
    public void clearAllExistingRecords() {
        String tableName = this.classType.getSimpleName();
        entityManager.createQuery("DELETE FROM " + tableName + " t ");
    }
}
