/**
 * 
 */
package com.playa.data.rest;

import retrofit.RestAdapter;


/**
 * The REST connector used to connect to different RESTful services
 * @author Jason Wong
 *
 */
public class RestConnector {
    
    private String serviceEndPoint;
    private RestAdapter restAdaptor;
    
    public RestConnector(String endPoint) {
        this.serviceEndPoint = endPoint;
        
        restAdaptor = new RestAdapter.Builder()
            .setEndpoint(this.getServiceEndPoint())
            .build();
    }
    
    /**
     * Return the service for the call.
     * 
     * @param serviceInterface
     * @return
     */
    public <T> T getService(Class<T> serviceInterface) {
        return this.restAdaptor.create(serviceInterface);
    }

    /**
     * @return the serviceEndPoint
     */
    public String getServiceEndPoint() {
        return serviceEndPoint;
    }

    /**
     * @param serviceEndPoint the serviceEndPoint to set
     */
    public void setServiceEndPoint(String serviceEndPoint) {
        this.serviceEndPoint = serviceEndPoint;
    }

}
