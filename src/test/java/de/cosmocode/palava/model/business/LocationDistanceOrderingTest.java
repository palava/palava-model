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

import java.util.Collections;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.inject.internal.Lists;

/**
 * Tests {@link Location.DistanceOrdering}.
 *
 * @author Willi Schoenborn
 */
public final class LocationDistanceOrderingTest {

    private static final Logger LOG = LoggerFactory.getLogger(LocationDistanceOrderingTest.class);

    private final Location berlin = createLocation("Berlin", 13.4, 52.5166667);
    private final Location munich = createLocation("Munich", 11.5754914283752, 48.1374325498109);
    private final Location moscow = createLocation("Moscow", 5.7522222, 37.6155556);
    private final Location ny = createLocation("NY", -74.0059729, 40.7142691);
    
    /**
     * Tests {@link Location.DistanceOrdering#compare(Location, Location)}.
     */
    @Test
    public void compare() {
        final List<Location> locations = Lists.newArrayList(moscow, munich, ny, berlin);
        final Ordering<Location> unit = new Location.DistanceOrdering(berlin); 
        
        LOG.info("Testing {} with {}", unit, locations);
        Collections.sort(locations, unit);
        Assert.assertEquals(locations, ImmutableList.of(berlin, munich, moscow, ny));
        
        LOG.info("Testing {}.reverse() with {}", unit, locations);
        Collections.sort(locations, unit.reverse());
        Assert.assertEquals(locations, ImmutableList.of(ny, moscow, munich, berlin));
        EasyMock.verify(berlin, munich, moscow, ny);
    }
    
    /**
     * Tests {@link Location.DistanceOrdering#compare(Location, Location)} with null values.
     */
    @Test
    public void nulls() {
        final Location nully = null;
        final Location nullCoords = createLocation("Null", null, null);
        final List<Location> locations = Lists.newArrayList(
            moscow, nully, munich, nullCoords, ny, berlin
        );
        final Ordering<Location> unit = Location.DistanceOrdering.create(berlin);
        
        LOG.info("Testing {} with {}", unit, locations);
        Collections.sort(locations, unit);
        Assert.assertEquals(locations, Lists.newArrayList(berlin, munich, moscow, ny, nullCoords, nully));
        EasyMock.verify(nullCoords);
        EasyMock.verify(berlin, munich, moscow, ny);
    }
    
    private Location createLocation(String name, Double longitude, Double latitude) {
        final Location location = EasyMock.createMock(name, Location.class);
        EasyMock.expect(location.getLongitude()).andStubReturn(longitude);
        EasyMock.expect(location.getLatitude()).andStubReturn(latitude);
        EasyMock.replay(location);
        return location;
    }
    
}
