/**
 * 
 */
package com.playa.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.playa.data.beans.Weather;
import com.playa.data.services.WeatherService;

/**
 * The main controller for /activities page. It is responsible for showing up activities,
 * performing search.
 * 
 * 
 * @author Jason Wong
 * 
 */
@Controller
@RequestMapping("/activities")
public class ActivitiesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActivitiesController.class);
    
    @Autowired
    private WeatherService service;
    
    @RequestMapping(method = RequestMethod.GET)
    public String getActivities() {
        Weather weatherInfo = service.getTodayWeather();
        
        LOGGER.info("Weather Info: " + weatherInfo);
        return "activities";
    }

}
