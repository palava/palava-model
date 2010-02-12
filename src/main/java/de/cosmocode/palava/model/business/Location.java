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

import org.geotools.referencing.GeodeticCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;

import de.cosmocode.json.JSONMapable;

/**
 * A location represents a geographic places addressed by a
 * longitude and a latitude.
 *
 * @author Willi Schoenborn
 */
public interface Location extends JSONMapable {
    
    double MAX_LONGITUDE = 180.0;
    double MIN_LONGITUDE = -180.0;
    
    double MAX_LATITUDE = 90.0;
    double MIN_LATITUDE = 0.0;
    
    /**
     * A orthodromic distance ordering based on a specified center location.
     *
     * @author Willi Schoenborn
     */
    public static final class DistanceOrdering extends Ordering<Location> {
        
        /**
         * A function which returns null if the given location contains a null
         * latitude or null longitude.
         */
        public static final Function<Location, Location> TO_NULL = new Function<Location, Location>() {
            
            @Override
            public Location apply(Location from) {
                return from.getLatitude() == null || from.getLongitude() == null ? null : from;
            }
            
            @Override
            public String toString() {
                return String.format("%s.TO_NULL", DistanceOrdering.class.getSimpleName());
            };
            
        };
        
        private static final Logger LOG = LoggerFactory.getLogger(DistanceOrdering.class);
        
        private final GeodeticCalculator calculator = new GeodeticCalculator();
        
        private final Location center;
        
        public DistanceOrdering(Location center) {
            this.center = Preconditions.checkNotNull(center, "Center");
            calculator.setStartingGeographicPoint(center.getLongitude(), center.getLatitude());
        }
       
        @Override
        public int compare(Location left, Location right) {
            if (left == right) return 0;
            calculator.setDestinationGeographicPoint(left.getLongitude(), left.getLatitude());
            final double leftDistance = calculator.getOrthodromicDistance();
            calculator.setDestinationGeographicPoint(right.getLongitude(), right.getLatitude());
            final double rightDistance = calculator.getOrthodromicDistance();
            if (LOG.isTraceEnabled()) {
                // to prevent auto-boxing
                LOG.trace("Comparing distances {} and {}", leftDistance, rightDistance);
            }
            return Double.compare(leftDistance, rightDistance);
        }
        
        @Override
        public String toString() {
            return String.format("%s.%s(%s)", 
                Location.class.getSimpleName(), DistanceOrdering.class.getSimpleName(), center
            );
        }
        
        /**
         * Creates a new {@link DistanceOrdering} which puts null locations and locations 
         * with null latitude or null longitude to the end.
         * 
         * @param center the center this ordering should use for distance
         *         calculations
         * @return an ordering of locations
         */
        public static Ordering<Location> create(Location center) {
            return new DistanceOrdering(center).nullsLast().onResultOf(TO_NULL).nullsLast(); 
        }
        
    }
    
    /**
     * Retrieve the latitude of this location.
     * 
     * @return the latitude or null if there is no latitude
     */
    Double getLatitude();
    
    /**
     * Sets the latitude of this location.
     * 
     * @param latitude the latitude, might be null
     * @throws IllegalArgumentException if latitude is greater than {@link Location#MAX_LATITUDE}
     *         or less than {@link Location#MIN_LATITUDE}
     */
    void setLatitude(Double latitude);
    
    /**
     * Retrieve the longitude of this location.
     * 
     * @return the longitude or null if there is no longitude
     */
    Double getLongitude();
    
    /**
     * Sets the longitude of this location.
     * 
     * @param longitude the longitude, might be null
     * @throws IllegalArgumentException if longitude is greater than {@link Location#MAX_LONGITUDE}
     *         or less than {@link Location#MIN_LONGITUDE}.
     */
    void setLongitude(Double longitude);
    
}
