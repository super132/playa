/**
 * 
 */
package com.playa.services.impl;

import java.util.List;

import com.playa.data.beans.Activity;
import com.playa.data.services.ActivityService;

/**
 * @author hcsrxo6
 *
 */
public class HkGovActivityService implements ActivityService {

    /**
     * Obtain the activities list from remote service provider. Due to the interface design, the implementation
     * returns only activity IDs.
     * 
     * @param date - The date string in YYYY-MM-DD to retrieve the activity from
     */
    public List<Activity> getActivities(String date) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.playa.services.ActivityService#getActivity(java.lang.String)
     */
    public Activity getActivity(String activityId) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.playa.services.ActivityService#getActivitiesDetail(java.lang.String)
     */
    public List<Activity> getActivitiesDetail(String date) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.playa.services.ActivityService#getActivities(java.util.List)
     */
    public List<Activity> getActivities(List<String> activityIds) {
        // TODO Auto-generated method stub
        return null;
    }

}
