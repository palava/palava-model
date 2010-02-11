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
    }
    
    private Location createLocation(String name, Double longitude, Double latitude) {
        final Location location = EasyMock.createMock(name, Location.class);
        EasyMock.expect(location.getLongitude()).andStubReturn(longitude);
        EasyMock.expect(location.getLatitude()).andStubReturn(latitude);
        EasyMock.replay(location);
        return location;
    }
    
}
