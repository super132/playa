/**
 * 
 */
package com.playa.data.services;

import java.util.List;

import com.playa.data.beans.Weather;

/**
 * This interface represents service class which retrieves weather information in RSS feed from the a provider, and 
 * returns the weather information for processing.
 * 
 * @author Jason Wong
 *
 */
public interface WeatherService {

    /**
     * Return the weather information of today (calculated using server time) from the provider.
     * 
     * TODO: add exception for caller to handle
     * @return WeatherData data - the weather information
     */
    Weather getTodayWeather();
    
    /**
     * Returns the weather information of the next number of days specified by the paramter. The start date is based 
     * on today.
     * 
     * @param days - the number of dates to retrieve the weather information.
     * @return
     */
    List<Weather> getFutureWeather(int days);
    
}
