/**
 * 
 */
package com.playa.data.services;

import java.util.List;

import com.playa.data.beans.Activity;

/**
 * The activity service to fetch activities data from a remote service provider. 
 * 
 * @author Jason Wong
 *
 */
public interface ActivityService {

    /**
     * Obtain the activity list for a date. The activity information is a simplified one which includes:
     * 
     * activity ID, organizer and summary.
     * 
     * from remote service provider. 
     * 
     * @param date
     * @return
     */
    List<Activity> getActivities(String date);
    
    /**
     * Obtain the activity detail using the given ID from remote service provider
     * 
     * @param activityId
     * @return
     */
    Activity getActivity(String activityId);
    
    /**
     * Obtain the activity details for a date from a remote service provider. 
     * @param date
     * @return
     */
    List<Activity> getActivitiesDetail(String date);
    
    /**
     * Obtain the activity details using the given activityIds from a remote service provider.
     * @param activityIds
     * @return
     */
    List<Activity> getActivities(List<String> activityIds); 
}
