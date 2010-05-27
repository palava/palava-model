/**
 * Copyright 2010 CosmoCode GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.cosmocode.palava.model.business;

import java.util.Locale;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.apache.commons.validator.EmailValidator;
import org.apache.commons.validator.UrlValidator;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;

import de.cosmocode.commons.Locales;
import de.cosmocode.commons.Patterns;
import de.cosmocode.commons.TrimMode;

/**
 * Abstract base implementation of the {@link AddressBase} interface.
 * 
 * @author Willi Schoenborn
 */
@Embeddable
@MappedSuperclass
public abstract class AbstractAddress implements AddressBase {
    
    private static final EmailValidator EMAIL_VALIDATOR = EmailValidator.getInstance();
    private static final UrlValidator URL_VALIDATOR = new UrlValidator();

    private static final Set<String> INVERSE_ADDRESS_COUNTRIES = ImmutableSet.of(
        Locale.US.getCountry(), 
        Locale.UK.getCountry(), 
        Locale.CANADA.getCountry(),
        Locales.AUSTRALIA.getCountry(),
        Locale.FRANCE.getCountry(),
        Locales.NEW_ZEALAND.getCountry()
    );
    
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
    
    @Column(unique = true)
    private String email;
    
    private String website;
    
    @Transient
    private final transient Location location = new InternalLocation();
    
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
    public String getLocalizedAddress() {
        if (INVERSE_ADDRESS_COUNTRIES.contains(countryCode)) {
            return getAddressInverse();
        } else {
            return getAddress();
        }
    }
    
    private String getAddress() {
        return String.format("%s %s", street, streetNumber).trim();
    }
    
    private String getAddressInverse() {
        return String.format("%s %s", streetNumber, street).trim();
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
    public void setCountryCode(String code) {
        this.countryCode = TrimMode.NULL.apply(code);
        if (countryCode == null) return;
        this.countryCode = countryCode.toUpperCase();
        Preconditions.checkArgument(Patterns.ISO_3166_1_ALPHA_2.matcher(countryCode).matches(), 
            "%s does not match %s", countryCode, Patterns.ISO_3166_1_ALPHA_2.pattern()
        );
    }
    
    @Override
    public Location getLocation() {
        return location;
    }
    
    /**
     * Internal implementation of the {@link Location} interface which
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
    public void setLocation(Location location) {
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
    public void setEmail(String e) {
        this.email = TrimMode.NULL.apply(e);
        if (email == null) return;
        Preconditions.checkArgument(EMAIL_VALIDATOR.isValid(email), "%s is not a valid email", email);
    }
    
    @Override
    public String getWebsite() {
        return website;
    }
    
    @Override
    public void setWebsite(String w) {
        this.website = TrimMode.NULL.apply(w);
        if (website == null) return;
        Preconditions.checkArgument(URL_VALIDATOR.isValid(website), "%s is not a valid website", website);
    }
    
}
