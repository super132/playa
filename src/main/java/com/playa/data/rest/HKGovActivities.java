/**
 * 
 */
package com.playa.data.rest;

import java.util.List;

import com.playa.data.beans.Activity;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * This interface represents the REST connector for obtaining JSON response from a RESTful service.
 * 
 * @author Jason Wong
 *
 */
public interface HKGovActivities {
    
    /**
     * The REST API to call HK government getting activity ID list
     * @param date
     * @return
     */
    @GET("/event-psi/json/calendar/{date}.json")
    List<String> getActivityIds(@Path("date") String date);
    
    /**
     * The REST API to call HK goverment getting activity detail
     * @param id
     * @param lang
     * @return
     */
    @GET("/event-psi/psi/{id}_{lang}.ics")
    Activity getActivity(@Path("id") String id, @Path("lang") String lang);
}
