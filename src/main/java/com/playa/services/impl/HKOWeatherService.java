/**
 * 
 */
package com.playa.services.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.playa.data.beans.Weather;
import com.playa.data.services.WeatherService;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.fetcher.FeedFetcher;
import com.sun.syndication.io.FeedException;

/**
 * This class retrieves weather information in RSS feed from the supplied provider
 * 
 * @author Jason Wong
 *
 */
public class HKOWeatherService implements WeatherService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(HKOWeatherService.class);
    
    private String todayWeatherUrl;
    private String futureDaysWeatherUrl;
    private FeedFetcher rssReader;
    
    private Pattern datePattern;
    private Pattern tempPattern;
    private Pattern humidPattern;
    private Pattern weatherPattern;
    
    /**
     * Default constructor
     */
    public HKOWeatherService() {
        this.todayWeatherUrl = null;
        this.futureDaysWeatherUrl = null;
    }
    
    /**
     * Constructor that takes the URLs as argument for fetching RSS feed 
     * @param todayWeatherUrl
     * @param futureDaysWeatherUrl
     */
    public HKOWeatherService(String todayWeatherUrl, String futureDaysWeatherUrl) {
        this.todayWeatherUrl = todayWeatherUrl;
        this.futureDaysWeatherUrl = futureDaysWeatherUrl;
    }
    
    public Weather getTodayWeather() {
        
        Weather result = null;
        
        try {
            SyndFeed weatherFeed = getRssReader().retrieveFeed(new URL(todayWeatherUrl));
            
            result = new Weather();
            List entries = weatherFeed.getEntries();
            
            if (entries != null && !entries.isEmpty()) {
                //Get the first entry which represent the current weather.
                SyndEntry entry = (SyndEntry)entries.get(0);
                //Get the weather information
                String data = entry.getDescription().getValue();
                
                String currentTempStr = getMatches(this.getTempPattern(), data);
                String currentHumidStr = getMatches(this.getHumidPattern(), data);
                //String weatherStr = getMatches(this.getWeatherPattern(), data);
                
                //setting the data
                GregorianCalendar calendar = new GregorianCalendar();
                calendar.set(Calendar.HOUR, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                //convert to UTC
                calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
                result.setDate(calendar.getTime());
                
                result.setCurrentTemp(currentTempStr == null ? null : currentTempStr.trim());
                result.setCurrentHumid(currentHumidStr == null ? null : currentHumidStr.trim());
            }
            
        } catch (MalformedURLException e) {
            LOGGER.error("Error occurs when paring URL for reading weather information.", e);
        } catch (IOException e) {
            LOGGER.error("Error occurs when reading RSS feed URL for reading weather information.", e);
        } catch (FeedException e) {
            LOGGER.error("Error occurs when parsing RSS feed.", e);
        } catch (Exception e) {
            LOGGER.error("General error occurs when processing RSS feed.", e);
        }
        
        
        return result;
    }
    
    //Private methods
    private String getMatches(Pattern pattern, String input) {
        String result = null;
        
        Matcher m = pattern.matcher(input);
        
        if(m.find()) {
            result = m.group(1);
        }
        
        return result;
    }

    public List<Weather> getFutureWeather(int days) {
        // TODO Auto-generated method stub
        return null;
    }
    
    /**
     * @return the todayWeatherUrl
     */
    public String getTodayWeatherUrl() {
        return todayWeatherUrl;
    }
    
    /**
     * @param todayWeatherUrl the todayWeatherUrl to set
     */
    public void setTodayWeatherUrl(String todayWeatherUrl) {
        this.todayWeatherUrl = todayWeatherUrl;
    }

    /**
     * @return the futureDaysWeatherUrl
     */
    public String getFutureDaysWeatherUrl() {
        return futureDaysWeatherUrl;
    }

    /**
     * @param futureDaysWeatherUrl the futureDaysWeatherUrl to set
     */
    public void setFutureDaysWeatherUrl(String futureDaysWeatherUrl) {
        this.futureDaysWeatherUrl = futureDaysWeatherUrl;
    }

    /**
     * @return the rssReader
     */
    public FeedFetcher getRssReader() {
        return rssReader;
    }

    /**
     * @param rssReader the rssReader to set
     */
    public void setRssReader(FeedFetcher rssReader) {
        this.rssReader = rssReader;
    }

    /**
     * @return the datePattern
     */
    public Pattern getDatePattern() {
        return datePattern;
    }

    /**
     * @param datePattern the datePattern to set
     */
    public void setDatePattern(Pattern datePattern) {
        this.datePattern = datePattern;
    }

    /**
     * @return the tempPattern
     */
    public Pattern getTempPattern() {
        return tempPattern;
    }

    /**
     * @param tempPattern the tempPattern to set
     */
    public void setTempPattern(Pattern tempPattern) {
        this.tempPattern = tempPattern;
    }

    /**
     * @return the humidPattern
     */
    public Pattern getHumidPattern() {
        return humidPattern;
    }

    /**
     * @param humidPattern the humidPattern to set
     */
    public void setHumidPattern(Pattern humidPattern) {
        this.humidPattern = humidPattern;
    }

    /**
     * @return the weatherPattern
     */
    public Pattern getWeatherPattern() {
        return weatherPattern;
    }

    /**
     * @param weatherPattern the weatherPattern to set
     */
    public void setWeatherPattern(Pattern weatherPattern) {
        this.weatherPattern = weatherPattern;
    }

}
