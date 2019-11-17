package com.junction.natio.web.config;

import com.junction.natio.core.model.GlobalSettingEntity;
import com.junction.natio.core.repository.IGlobalSettingRepository;
import com.junction.natio.core.utils.DateUtils;
import com.junction.natio.core.utils.GlobalSettingUtils;
import com.junction.natio.web.model.LocationEntity;
import com.junction.natio.web.model.LocationPoint;
import com.junction.natio.web.model.UserEntity;
import com.junction.natio.web.repository.ILocationRepository;
import com.junction.natio.web.repository.IUserRepository;
import com.junction.natio.web.service.ICityNatureAPIService;
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

    @Autowired
    private ICityNatureAPIService cityNatureAPIService;

    @Autowired
    private ILocationRepository locationRepository;

    @Autowired
    private IUserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        this.initMyTrips();
    }

    private void initMyTrips() {
        UserEntity user = userRepository.findOne(1l);
        if (user == null) {
            UserEntity createdUser = new UserEntity();
            createdUser.setEmail("test@gmail.com");
            createdUser.setName("John Doe");
            createdUser.setPassword("$2a$10$aMz/HmSCNl2DMbUhTy0DbeAJ5Us7SBY5G1S4yQtfCn1o1SpKbKfRW");
            userRepository.save(createdUser);
        }
        List<LocationEntity> existingLocations = locationRepository.findAll();
        List<String> entities = cityNatureAPIService.getAllNatureLocation();
        List<LocationPoint> locationPoints = cityNatureAPIService.getByNatureLocationName(entities.get(0));
        if (!locationPoints.isEmpty() && existingLocations.size() == 0) {
            for (LocationPoint point : locationPoints) {
                LocationEntity entity = new LocationEntity();
                entity.setLat(point.getLat());
                entity.setLng(point.getLng());
                entity.setName(point.getName());
                entity.setPointInfo(point.getPointInfo());
                UserEntity userFound = userRepository.findOne(1l);
                user.setId(userFound.getId());
                entity.setUserId(user);
                this.locationRepository.save(entity);
            }
            System.out.println("-----------------Data Source for GlobalSetting Initialized----------------------");
        }
    }
}
