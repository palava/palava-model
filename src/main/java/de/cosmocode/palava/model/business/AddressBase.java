/**
 * palava - a java-php-bridge
 * Copyright (C) 2007-2010  CosmoCode GmbH
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package de.cosmocode.palava.model.business;

import de.cosmocode.json.JSONMapable;

/**
 * TODO consider localizing street + streetNumber
 *
 * @author Willi Schoenborn
 */
public interface AddressBase extends Geographical, JSONMapable {

    String getStreet();
    
    void setStreet(String street);
    
    String getStreetNumber();
    
    void setStreetNumber(String streetNumber);
    
    String getAdditional();
    
    void setAdditional(String additional);
    
    String getPostalCode();
    
    void setPostalCode(String postalCode);
    
    String getDistrict();
    
    void setDistrict(String district);
    
    String getCityName();
    
    void setCityName(String cityName);
    
    String getState();
    
    void setState(String state);
    
    String getCountryCode();
    
    /**
     * TODO document toUpperCase
     * 
     * @param countryCode
     */
    void setCountryCode(String countryCode);
    
    /**
     * TODO never return null
     * 
     * @return 
     */
    Location getLocation();
    
    void setLocation(Location location);
    
    boolean hasLocation();
    
    String getPhone();
    
    void setPhone(String phone);
    
    String getMobilePhone();
    
    void setMobilePhone(String mobilePhone);
    
    String getFax();
    
    void setFax(String fax);
    
    String getEmail();
    
    void setEmail(String email);
    
    String getWebsite();
    
    void setWebsite(String website);
    
}
