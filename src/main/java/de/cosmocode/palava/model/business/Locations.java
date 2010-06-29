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
 * Utility class for {@link Location}s.
 *
 * @since 2.1
 * @author Willi Schoenborn
 */
public final class Locations {
    
    private Locations() {
        
    }
    
    private static void checkArgument(boolean expression, String format, double a, double b) {
        if (expression) {
            return;
        } else {
            throw new IllegalArgumentException(String.format(format, a, b));
        }
    }

    private static double checkLatitude(double latitude) {
        checkArgument(latitude >= Location.MIN_LATITUDE, "%s must not be less than %s", 
            latitude, Location.MIN_LATITUDE);
        checkArgument(latitude <= Location.MAX_LATITUDE, "%s must not be greater than %s", 
            latitude, Location.MAX_LATITUDE);
        return latitude;
    }
    
    private static Double checkLatitude(Double latitude) {
        Preconditions.checkNotNull(latitude, "Latitude");
        checkLatitude(latitude.doubleValue());
        return latitude;
    }
    
    private static double checkLongitude(double longitude) {
        checkArgument(longitude >= Location.MIN_LONGITUDE, "%s must not be less than %s", 
            longitude, Location.MIN_LONGITUDE);
        checkArgument(longitude <= Location.MAX_LONGITUDE, "%s must not be greater than %s",
            longitude, Location.MAX_LONGITUDE);
        return longitude;
    }
    
    private static Double checkLongitude(Double longitude) {
        Preconditions.checkNotNull(longitude, "Longitude");
        checkLongitude(longitude.doubleValue());
        return longitude;
    }
    
    /**
     * Returns an unmodifiable view of the given location.
     * 
     * @since 2.1
     * @param location the backing location
     * @return an unmodifiable view of the given location
     * @throws NullPointerException if location is null 
     */
    public static Location unmodifiableLocation(Location location) {
        return new UnmodifiableLocation(location);
    }
    
    /**
     * Implementation of {@link Locations#unmodifiableLocation(Location)}.
     *
     * @since 2.1
     * @author Willi Schoenborn
     */
    private static final class UnmodifiableLocation extends ForwardingLocation {
        
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
    
    /**
     * Creates a modifiable {@link Location} using the given latitude and longitude.
     * 
     * @since 2.1
     * @param latitude the location's latitude
     * @param longitude the location's longitude
     * @return a modifiable location initialized with the given coordinates
     * @throws IllegalArgumentException if latitude is greater than {@link Location#MAX_LATITUDE}
     *         or less than {@link Location#MIN_LATITUDE} or longitude is greater than {@link Location#MAX_LONGITUDE}
     *         or less than {@link Location#MIN_LONGITUDE}.
     */
    public static Location modifiableLocation(Double latitude, Double longitude) {
        return new ModifiableLocation(latitude, longitude);
    }
    
    /**
     * Implementation of {@link Locations#modifiableLocation(Double, Double)}.
     *
     * @since 2.1
     * @author Willi Schoenborn
     */
    private static final class ModifiableLocation extends AbstractLocation {
        
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
            this.latitude = latitude == null ? null : checkLatitude(latitude);
        }

        @Override
        public void setLongitude(Double longitude) {
            this.longitude = longitude == null ? null : checkLongitude(longitude);
        }
        
    }
    
    /**
     * Returns an immutable copy of the given location.
     * 
     * @since 2.1
     * @param location the location to be copied
     * @return an immutable location initialized with the same latitude and longitude as the
     *         specified one
     * @throws NullPointerException if location is null 
     */
    public static Location immutableLocation(Location location) {
        Preconditions.checkNotNull(location, "Location");
        return new ImmutableLocation(location.getLatitude(), location.getLongitude());
    }
    
    /**
     * Returns an immutable location initialized with the given coordinates.
     * 
     * @since 2.1
     * @param latitude the location's latitude (null permitted)
     * @param longitude the location's longitude (null permitted)
     * @return am immutable location initialized with the given latitude and longitude
     * @throws IllegalArgumentException if latitude is greater than {@link Location#MAX_LATITUDE}
     *         or less than {@link Location#MIN_LATITUDE} or longitude is greater than {@link Location#MAX_LONGITUDE}
     *         or less than {@link Location#MIN_LONGITUDE}.
     */
    public static Location immutableLocation(Double latitude, Double longitude) {
        if (latitude != null) checkLatitude(latitude);
        if (longitude != null) checkLongitude(longitude);
        return new ImmutableLocation(latitude, longitude);
    }
    
    /**
     * Implementation of {@link Locations#immutableLocation(double, double)}.
     *
     * @since 2.1
     * @author Willi Schoenborn
     */
    private static final class ImmutableLocation extends AbstractLocation {

        private final Double latitude;
        private final Double longitude;

        public ImmutableLocation(Double latitude, Double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
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
            throw new UnsupportedOperationException();
        }

        @Override
        public void setLongitude(Double longitude) {
            throw new UnsupportedOperationException();
        }

    }
    
}