/**
 * palava - a java-php-bridge
 * Copyright (C) 2007  CosmoCode GmbH
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

import javax.persistence.Column;
import javax.persistence.Transient;

import com.google.common.base.Preconditions;

import de.cosmocode.commons.TrimMode;
import de.cosmocode.json.JSONRenderer;
import de.cosmocode.json.RenderLevel;

/**
 * Abstract base implementation of the {@link AddressBase} interface.
 * 
 * @author Willi Schoenborn
 */
public abstract class AbstractAddress implements AddressBase {

    private String street;
    
    @Column(name = "street_number")
    private String streetNumber;
    
    private String additional;
    
    @Column(name = "postal_code")
    private String postalCode;
    
    private String district;
    
    @Column(name = "city_name")
    private String cityName;
    
    private String state;
    
    @Column(name = "country_code")
    private String countryCode;

    private Double latitude;
    
    private Double longitude;
    
    private String phone;
    
    @Column(name = "mobile_phone")
    private String mobilePhone;
    
    private String fax;
    
    private String email;
    
    private String website;
    
    @Transient
    private transient LocationBase location;
    
    @Override
    public String getStreet() {
        return street;
    }
    
    @Override
    public void setStreet(String street) {
        this.street = TrimMode.NULL.apply(street);
    }
    
    @Override
    public String getStreetNumber() {
        return streetNumber;
    }
    
    @Override
    public void setStreetNumber(String streetNumber) {
        this.streetNumber = TrimMode.NULL.apply(streetNumber);
    }
    
    @Override
    public String getAdditional() {
        return additional;
    }
    
    @Override
    public void setAdditional(String additional) {
        this.additional = TrimMode.NULL.apply(additional);
    }
    
    @Override
    public String getPostalCode() {
        return postalCode;
    }
    
    @Override
    public void setPostalCode(String postalCode) {
        this.postalCode = TrimMode.NULL.apply(postalCode);
    }
    
    @Override
    public String getDistrict() {
        return district;
    }
    
    @Override
    public void setDistrict(String district) {
        this.district = TrimMode.NULL.apply(district);
    }
    
    @Override
    public String getCityName() {
        return cityName;
    }
    
    @Override
    public void setCityName(String cityName) {
        this.cityName = TrimMode.NULL.apply(cityName);
    }
    
    @Override
    public String getState() {
        return state;
    }
    
    @Override
    public void setState(String state) {
        this.state = TrimMode.NULL.apply(state);
    }
    
    @Override
    public String getCountryCode() {
        return countryCode == null ? null : countryCode.toUpperCase();
    }
    
    @Override
    public void setCountryCode(String countryCode) {
        this.countryCode = TrimMode.NULL.apply(countryCode);
        if (this.countryCode == null) return;
        this.countryCode = this.countryCode.toUpperCase();
    }
    
    @Override
    public LocationBase getLocation() {
        if (location == null) {
            location = new InternalLocation();
        }
        return location;
    }
    
    /**
     * Internal implementation of the {@link LocationBase} interface which
     * owns a reference to the enclosing class and is able to directly manipulate the
     * corresponding values.
     *
     * @author Willi Schoenborn
     */
    private final class InternalLocation extends AbstractLocation {
        
        @Override
        public Double getLatitude() {
            return latitude;
        }
        
        @Override
        public void setLatitude(Double latitude) {
            AbstractAddress.this.latitude = latitude;
        }
        
        @Override
        public Double getLongitude() {
            return longitude;
        }
        
        @Override
        public void setLongitude(Double longitude) {
            AbstractAddress.this.longitude = longitude;
        }
        
    }
    
    @Override
    public void setLocation(LocationBase location) {
        Preconditions.checkNotNull(location, "Location");
        this.latitude = location.getLatitude();
        this.longitude = location.getLongitude();
    }
    
    @Override
    public boolean hasLocation() {
        return latitude != null && longitude != null;
    }
    
    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = TrimMode.NULL.apply(phone);
    }
    
    @Override
    public String getMobilePhone() {
        return mobilePhone;
    }
    
    @Override
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = TrimMode.NULL.apply(mobilePhone);
    }
    
    @Override
    public String getFax() {
        return fax;
    }
    
    @Override
    public void setFax(String fax) {
        this.fax = TrimMode.NULL.apply(fax);
    }
    
    @Override
    public String getEmail() {
        return email;
    }
    
    @Override
    public void setEmail(String email) {
        this.email = TrimMode.NULL.apply(email);
    }
    
    @Override
    public String getWebsite() {
        return website;
    }
    
    @Override
    public void setWebsite(String website) {
        this.website = TrimMode.NULL.apply(website);
    }
    
    @Override
    public JSONRenderer renderAsMap(JSONRenderer renderer) {
        if (renderer.eq(RenderLevel.MEDIUM)) {
            renderer.
                key("street").value(getStreet()).
                key("streetNumber").value(getStreetNumber()).
                key("postalCode").value(getPostalCode()).
                key("cityName").value(getCityName()).
                key("countryCode").value(getCountryCode()).
                key("location").object(getLocation()).
                key("email").value(getEmail()).
                key("website").value(getWebsite());
        }
        if (renderer.eq(RenderLevel.LONG)) {
            renderer.
                key("additional").value(getAdditional()).
                key("district").value(getDistrict()).
                key("state").value(getState()).
                key("phone").value(getPhone()).
                key("mobilePhone").value(getMobilePhone()).
                key("fax").value(getFax());
        }
        return renderer;
    }

}
