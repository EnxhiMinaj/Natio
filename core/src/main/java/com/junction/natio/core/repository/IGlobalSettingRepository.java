package com.junction.natio.core.repository;


import com.junction.natio.core.model.GlobalSettingEntity;

/**

 */
public interface IGlobalSettingRepository extends ICrudRepository<GlobalSettingEntity, Long> {
    void clearAllExistingRecords();

}
