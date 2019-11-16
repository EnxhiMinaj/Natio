package com.junction.natio.core.repository;


import com.junction.natio.core.model.GlobalSettingEntity;

/**
 * Created by Anil Kumal on 02/02/2019.
 */
public interface IGlobalSettingRepository extends ICrudRepository<GlobalSettingEntity, Long> {
    void clearAllExistingRecords();

}
