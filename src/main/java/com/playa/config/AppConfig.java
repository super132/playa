/**
 * 
 */
package com.playa.config;

import java.util.regex.Pattern;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.playa.data.rest.RestConnector;
import com.playa.data.services.ActivityService;
import com.playa.data.services.WeatherService;
import com.playa.services.impl.HKOWeatherService;
import com.playa.services.impl.HkGovActivityService;
import com.sun.syndication.fetcher.impl.HttpURLFeedFetcher;

/**
 * The main spring configuration class for DI.
 * 
 * @author Jason Wong
 *
 */
@Configuration
public class AppConfig {
    
    @Bean
    public WeatherService weatherService() {
        HKOWeatherService service = new HKOWeatherService(
                "http://rss.weather.gov.hk/rss/CurrentWeather.xml",
                "http://rss.weather.gov.hk/rss/SeveralDaysWeatherForecast.xml"
                );
        
//        service.setDatePattern(Pattern.compile("Date\\/Month\\:\\s*([0-9]{1,2}\\/[0-9]{1,2})"));
//        service.setTempPattern(Pattern.compile("Temp\\ range\\:\\s*([0-9\\-]{1,3}\\s*\\-\\s*[0-9\\-]{1,3}) C"));
//        service.setHumidPattern(Pattern.compile("\\s*([0-9\\-]{1,3}\\s*\\-\\s*[0-9\\-]{1,3}) per.{4,5}"));
//        service.setWeatherPattern(Pattern.compile("Weather\\:\\s*([a-zA-Z\\. 0-9\\-]+)\\<br\\/\\>"));
        
        service.setTempPattern(Pattern.compile("Air\\ temperature\\ \\:\\s*([0-9\\-]{1,3})\\s*degrees"));
        service.setHumidPattern(Pattern.compile("Relative\\ Humidity\\ \\:\\s*([0-9\\-]{1,3})\\s*per cent"));
        
        service.setRssReader(new HttpURLFeedFetcher());
        
        return service;
    }
    
    @Bean
    public ActivityService activityService() {
        HkGovActivityService service = new HkGovActivityService();
        
        service.setConnector(activityHKGovRestConnector());
        
        return (ActivityService)service;
    }

    /**
     * REST connector for activity service
     * @return
     */
    @Bean
    public RestConnector activityHKGovRestConnector() {
        //connect to HK government services
        RestConnector connector = new RestConnector("http://ogcef.one.gov.hk");
        
        return connector;
    }
    
}
