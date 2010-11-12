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

import de.cosmocode.commons.Conditions;

/**
 * Implementation of {@link Locations#modifiableLocation(Double, Double)}.
 *
 * @since 2.1
 * @author Willi Schoenborn
 */
final class ModifiableLocation extends AbstractLocation {
    
    private Double latitude;
    
    private Double longitude;

    public ModifiableLocation(Double latitude, Double longitude) {
        setLatitude(latitude);
        setLongitude(longitude);
    }

    @Override
    public Double getLatitude() {
        return latitude;
    }

    @Override
    public Double getLongitude() {
        return longitude;
    }

    @Override
    public void setLatitude(Double latitude) {
        this.latitude = latitude == null ? null : Conditions.checkArgument(Location.VALID_LATITUDE, latitude);
    }

    @Override
    public void setLongitude(Double longitude) {
        this.longitude = longitude == null ? null : Conditions.checkArgument(Location.VALID_LONGITUDE, longitude);
    }
    
}
