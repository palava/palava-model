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

import javax.measure.Measure;
import javax.measure.quantity.Length;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

import org.geotools.referencing.GeodeticCalculator;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;

import de.cosmocode.commons.Conditions;

/**
 * Utility class for {@link Location}s.
 *
 * @since 2.1
 * @author Willi Schoenborn
 */
public final class Locations {
    
    private Locations() {
        
    }
    
    /**
     * Returns a location which is not null, but provides only null coordinates.
     * The returned location is immutable, to put it in another way: both {@link Location#setLatitude(Double)}
     * and {@link Location#setLongitude(Double)} throw {@link UnsupportedOperationException}s.
     * 
     * <p>
     *   This location is especially useful if you want to get rid of null checks. If any entity
     *   does not have an associated location, just return this.
     * </p>
     *
     * @since 3.3
     * @return a dummy location.
     */
    public static Location none() {
        return NoneLocation.INSTANCE;
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
     * Creates a modifiable {@link Location} using the given latitude and longitude.
     * 
     * @since 2.1
     * @param latitude the location's latitude (null permitted)
     * @param longitude the location's longitude (null permitted)
     * @return a modifiable location initialized with the given coordinates
     * @throws IllegalArgumentException if latitude is greater than {@link Location#MAX_LATITUDE}
     *         or less than {@link Location#MIN_LATITUDE} or longitude is greater than {@link Location#MAX_LONGITUDE}
     *         or less than {@link Location#MIN_LONGITUDE}.
     */
    public static Location modifiableLocation(Double latitude, Double longitude) {
        return new ModifiableLocation(latitude, longitude);
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
        if (latitude != null) Conditions.checkArgument(Location.VALID_LATITUDE, latitude);
        if (longitude != null) Conditions.checkArgument(Location.VALID_LONGITUDE, longitude);
        return new ImmutableLocation(latitude, longitude);
    }
    
    /**
     * Calculates the distance between two locations in meters.
     *
     * @since 3.3
     * @param source the source location
     * @param destination the destination location
     * @return the distance between source and destination in meters
     * @throws NullPointerException if source or destination is null
     */
    public static long distance(Location source, Location destination) {
        Preconditions.checkNotNull(source, "Source");
        Preconditions.checkNotNull(destination, "Destination");
        final GeodeticCalculator calculator = new GeodeticCalculator();
        calculator.setStartingGeographicPoint(source.getLongitude(), source.getLatitude());
        calculator.setDestinationGeographicPoint(destination.getLongitude(), destination.getLatitude());
        return (long) calculator.getOrthodromicDistance();
    }

    /**
     * Calculates the distance between two locations in the specified unit.
     *
     * @since 3.3
     * @param source the source location
     * @param destination the destination location
     * @param unit the lenth unit 
     * @return the distance between source and destination in the given unit
     * @throws NullPointerException if source or destination is null
     */
    public static long distance(Location source, Location destination, Unit<Length> unit) {
        final long distance = distance(source, destination);
        return Measure.valueOf(distance, SI.METER).longValue(unit);
    }
    
}
