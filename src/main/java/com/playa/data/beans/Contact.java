/**
 * 
 */
package com.playa.data.beans;

import java.util.List;

/**
 * Represents contact information of an activity
 * 
 * @author Jason Wong
 *
 */
public class Contact {

    private List<String> phones;
    private List<String> faxes;
    
    /**
     * @return the phones
     */
    public List<String> getPhones() {
        return phones;
    }
    
    /**
     * @param phones the phones to set
     */
    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    /**
     * @return the faxes
     */
    public List<String> getFaxes() {
        return faxes;
    }

    /**
     * @param faxes the faxes to set
     */
    public void setFaxes(List<String> faxes) {
        this.faxes = faxes;
    }
}
