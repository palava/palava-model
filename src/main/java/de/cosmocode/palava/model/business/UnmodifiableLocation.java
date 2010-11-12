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

import com.google.common.base.Preconditions;

/**
 * Implementation of {@link Locations#unmodifiableLocation(Location)}.
 *
 * @since 2.1
 * @author Willi Schoenborn
 */
final class UnmodifiableLocation extends ForwardingLocation {
    
    private final Location location;

    public UnmodifiableLocation(Location location) {
        this.location = Preconditions.checkNotNull(location, "Location");
    }

    @Override
    protected Location delegate() {
        return location;
    }

    @Override
    public void setLatitude(Double latitude) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setLongitude(Double longitude) {
        throw new UnsupportedOperationException();
    }
    
}
