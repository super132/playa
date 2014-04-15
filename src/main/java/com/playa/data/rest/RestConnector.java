/**
 * 
 */
package com.playa.data.rest;

import retrofit.RestAdapter;
import retrofit.converter.Converter;


/**
 * The REST connector used to connect to different RESTful services
 * @author Jason Wong
 *
 */
public class RestConnector {
    
    private String serviceEndPoint;
    
    public RestConnector(String endPoint) {
        this.serviceEndPoint = endPoint;
        
    }
    
    /**
     * Return the service for the call.
     * 
     * @param serviceInterface
     * @return
     */
    public <T> T getService(Class<T> serviceInterface) {
        
        return this.getService(serviceInterface, null);
    }
    
    /**
     * Return the service for the call with the custom converter converting the response to match the output of the service.
     * 
     * @param serviceInterface
     * @param converter - custom converter for converting results to match the response type defined in serviceInterface.
     * @return
     */
    public <T> T getService(Class<T> serviceInterface, Converter converter) {
        
        RestAdapter.Builder builder = new RestAdapter.Builder()
        .setEndpoint(this.getServiceEndPoint());
        
        if (converter != null) {
            builder.setConverter(converter);
        }
        
        RestAdapter restAdaptor = builder.build();
        
        return restAdaptor.create(serviceInterface);
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
