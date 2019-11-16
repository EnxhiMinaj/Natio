package com.junction.natio.web.config;

import com.junction.natio.core.model.GlobalSettingEntity;
import com.junction.natio.core.repository.IGlobalSettingRepository;
import com.junction.natio.core.utils.DateUtils;
import com.junction.natio.core.utils.GlobalSettingUtils;
import com.junction.natio.web.model.UserEntity;
import com.junction.natio.web.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * DataSourceInitializer populates the database with some
 * initial data for GlobalSetting using a JPA repository.
 * <p>
 * This component is started only when db.init property is set to true
 */
@Component
@ConditionalOnProperty(name = "db.init", havingValue = "true")

public class DataSourceInitializer implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {

    }
}
