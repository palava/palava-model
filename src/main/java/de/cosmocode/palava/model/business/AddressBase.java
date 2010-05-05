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

import de.cosmocode.commons.Patterns;

/**
 * Interface definition of reusable address entities.
 * 
 * <p>
 *   As long as not stated differently, returned null values are valid
 *   and represent no information given.
 * </p>
 *
 * @since 2.0
 * @author Willi Schoenborn
 */
public interface AddressBase extends Geographical {

    /**
     * Retrieves the street name of this address.
     * 
     * <p>
     *   Consider using {@link #getLocalizedAddress()} when 
     *   localized combination of {@link #getStreet()} and {@link #getStreetNumber()}
     *   is desired.
     * </p>
     * 
     * @since 2.0
     * @return the street name
     */
    String getStreet();
    
    /**
     * Changes the street name of this address. The specified
     * value may be trimmed before applied.
     * 
     * @since 2.0
     * @param street the new street name
     */
    void setStreet(String street);
    
    /**
     * Retrieves the street number of this address.
     * 
     * <p>
     *   Consider using {@link #getLocalizedAddress()} when 
     *   localized combination of {@link #getStreet()} and {@link #getStreetNumber()}
     *   is desired.
     * </p>
     * 
     * @since 2.0
     * @return the street number
     */
    String getStreetNumber();
    
    /**
     * Changes the street number of this address. The specified
     * value may be trimmed before applied.
     * 
     * @since 2.0
     * @param streetNumber the new street number
     */
    void setStreetNumber(String streetNumber);
    
    /**
     * Localized version of street and streetNumber as described
     * in this <a href="http://en.wikipedia.org/wiki/Address_(geography)#Mailing_address_format_by_country">
     * Wikipedia article</a>.
     * 
     * <p>
     *   If no country code is set, the order defaults to: {@code Prenzlauer Allee 36}.
     * </p>
     * 
     * @return a localized version depending on the countryCode
     *         of this address
     */
    String getLocalizedAddress();
    
    /**
     * Retrieves the additional address information of this address.
     * This may map to the staircase, level, room number, etc.
     * 
     * @since 2.0
     * @return the additional information of this address
     */
    String getAdditional();
    
    /**
     * Changes the additional address information of this address. The specified
     * value may be trimmed before applied.
     * 
     * @since 2.0
     * @param additional the new additional information
     */
    void setAdditional(String additional);
    
    /**
     * Retrieves the postal code of this address.
     * 
     * @since 2.0
     * @return the postal code of this address
     */
    String getPostalCode();
    
    /**
     * Changes the postal code of this address. The specified
     * value may be trimmed before applied.
     * 
     * @since 2.0
     * @param postalCode the new postal code
     */
    void setPostalCode(String postalCode);
    
    /**
     * Retrieves the district of this address.
     * 
     * @since 2.0
     * @return the district of this address
     */
    String getDistrict();
    
    /**
     * Changes the district of this address. The specified
     * value may be trimmed before applied.
     * 
     * @since 2.0
     * @param district the new district
     */
    void setDistrict(String district);
    
    /**
     * Retrieves the city name of this address.
     * 
     * @since 2.0
     * @return the name of the city of this address
     */
    String getCityName();
    
    /**
     * Changes the city name of this address. The specified
     * value may be trimmed before applied.
     * 
     * @since 2.0
     * @param cityName the new city name
     */
    void setCityName(String cityName);
    
    /**
     * Retrieves the federal state of this address.
     * 
     * @since 2.0
     * @return the state of this address
     */
    String getState();
    
    /**
     * Changes the state of this address. The specified
     * value may be trimmed before applied.
     * 
     * @since 2.0
     * @param state the new state
     */
    void setState(String state);
    
    /**
     * Retrieves the ISO 3166-1 alhpa 2 country code of this address.
     * 
     * @since 2.0
     * @return the country code of this address
     */
    String getCountryCode();
    
    /**
     * Changes the country code of this address. The specified
     * value may be trimmed and changed to uppercase before applied.
     * 
     * @param countryCode the new country code
     * @throws IllegalArgumentException if the specified code is not null and does not
     *         match {@link Patterns#ISO_3166_1_ALPHA_2}
     */
    void setCountryCode(String countryCode);
    
    /**
     * Retrieves the {@link Location location} of this address.
     * 
     * @return the location of this address, may never be null
     */
    Location getLocation();
    
    /**
     * Changes the location of this address.
     * 
     * @since 2.0 
     * @param location the new location
     * @throws NullPointerException if location is null
     */
    void setLocation(Location location);
    
    /**
     * Checks whether this address has a location.
     * 
     * @since 2.0
     * @return true if this address contains information about a location, false otherwise
     */
    boolean hasLocation();
    
    /**
     * Retrieves the phone number of this address.
     * 
     * @since 2.0
     * @return the phone number of this address
     */
    String getPhone();
    
    /**
     * Changes the phone number of this address. The specified
     * value may be trimmed before applied.
     * 
     * @since 2.0
     * @param phone the new phone number
     */
    void setPhone(String phone);
    
    /**
     * Retrieves the mobile phone numner of this address.
     * 
     * @since 2.0
     * @return the phone number of this address
     */
    String getMobilePhone();
    
    /**
     * Changes the phone number of this address. The specified
     * value may be trimmed before applied.
     * 
     * @since 2.0
     * @param mobilePhone the new phone number
     */
    void setMobilePhone(String mobilePhone);
    
    /**
     * Retrieves the fax number of this address.
     * 
     * @since 2.0
     * @return the fax number of this address
     */
    String getFax();
    
    /**
     * Changes the fax number of this address. The specified
     * value may be trimmed before applied.
     * 
     * @since 2.0
     * @param fax the new fax number of this address
     */
    void setFax(String fax);
    
    /**
     * Retrieves the email of this addresss.
     * 
     * @since 2.0
     * @return the email of this address
     */
    String getEmail();
    
    /**
     * Changes the email of this address. The specified
     * value may be trimmed before applied.
     * 
     * @since 2.0
     * @param email the new email
     * @throws IllegalArgumentException if email is not null and is not a valid email
     */
    void setEmail(String email);
    
    /**
     * Retrieves the website of this address.
     * 
     * @since 2.0
     * @return the website of this address
     */
    String getWebsite();
    
    /**
     * Changes the website of this address.
     * 
     * @since 2.0
     * @param website the new website of this address
     * @throws IllegalArgumentException if website is not null and is not a valid website
     */
    void setWebsite(String website);
    
}
