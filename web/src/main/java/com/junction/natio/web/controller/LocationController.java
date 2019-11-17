package com.junction.natio.web.controller;

import com.junction.natio.core.constant.WebResourceConstant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(LocationController.BASE_URL)
public class LocationController {
    public static final String BASE_URL = WebResourceConstant.NATIO.LOCATION;

}
