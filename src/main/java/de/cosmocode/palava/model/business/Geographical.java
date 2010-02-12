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

import com.google.common.base.Function;

import de.cosmocode.json.JSONMapable;

/**
 * A geographical is associated with a {@link Location}.
 *
 * @author Willi Schoenborn
 */
public interface Geographical extends JSONMapable {

    /**
     * Can be used in combination with {@link Location.DistanceOrdering} to create
     * a distance ordering for {@link Geographical}s.
     * <p>
     *   {@code Location.DistanceOrdering.create(center).onResultOf(Geographical.TO_LOCATION).nullsLast()}
     * </p>
     */
    Function<Geographical, Location> TO_LOCATION = new Function<Geographical, Location>() {
        
        @Override
        public Location apply(Geographical from) {
            return from.getLocation();
        }
        
        @Override
        public String toString() {
            return String.format("%s.TO_LOCATION", Geographical.class.getSimpleName());
        };
        
    };
    
    /**
     * Retrieves the location of this geographical.
     * 
     * @return the location or null if there is no location
     */
    Location getLocation();
    
}
