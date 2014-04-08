/**
 * 
 */
package com.playa.data.beans;

import java.util.Date;

import com.playa.WeatherType;

/**
 * A POJO represents the weather information obtained from WeatherService.
 * 
 * @author Jason Wong
 *
 */
public class Weather {

    private Date date;
    private String currentTemp;
    private String currentHumid;
    private WeatherType type;
    
    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }
    
    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the currentTemp
     */
    public String getCurrentTemp() {
        return currentTemp;
    }

    /**
     * @param currentTemp the currentTemp to set
     */
    public void setCurrentTemp(String currentTemp) {
        this.currentTemp = currentTemp;
    }

    /**
     * @return the currentHumid
     */
    public String getCurrentHumid() {
        return currentHumid;
    }

    /**
     * @param currentHumid the currentHumid to set
     */
    public void setCurrentHumid(String currentHumid) {
        this.currentHumid = currentHumid;
    }

    /**
     * @return the type
     */
    public WeatherType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(WeatherType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Date: " + this.date + ", current Temp.: " + this.currentTemp + ", current Hudmidity: " + this.currentHumid + ", weather type: " + this.type;
    }
    
    
}
