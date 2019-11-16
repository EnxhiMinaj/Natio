package com.junction.natio.core.service.impl;


import com.junction.natio.core.model.GlobalSettingEntity;
import com.junction.natio.core.repository.IGlobalSettingRepository;
import com.junction.natio.core.service.IGlobalSettingService;
import org.springframework.stereotype.Service;

/**
 * Created by Anil Kumal on 01/12/2018.
 */
@Service
public class GlobalSettingServiceImpl extends CrudServiceImpl<GlobalSettingEntity, Long> implements IGlobalSettingService {

    public GlobalSettingServiceImpl(IGlobalSettingRepository storageRepository) {
        super(storageRepository);

    }


}
