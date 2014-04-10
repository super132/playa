/**
 * 
 */
package com.playa.data.beans;

/**
 * Represents a geo-location information of an activity
 * 
 * @author Jason Wong
 *
 */
public class GeoLocation {
    
    private long lat;
    private long lng;
    
    /**
     * @return the lat
     */
    public long getLat() {
        return lat;
    }
    
    /**
     * @param lat the lat to set
     */
    public void setLat(long lat) {
        this.lat = lat;
    }

    /**
     * @return the lng
     */
    public long getLng() {
        return lng;
    }

    /**
     * @param lng the lng to set
     */
    public void setLng(long lng) {
        this.lng = lng;
    }
}
