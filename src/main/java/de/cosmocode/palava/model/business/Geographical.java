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

import com.google.common.base.Function;

import de.cosmocode.rendering.Renderable;

/**
 * A geographical is associated with a {@link Location}.
 *
 * @author Willi Schoenborn
 */
public interface Geographical extends Renderable {

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
            return "Geographical.TO_LOCATION";
        };
        
    };
    
    /**
     * Retrieves the location of this geographical.
     * 
     * @return the location or null if there is no location
     */
    Location getLocation();
    
}
