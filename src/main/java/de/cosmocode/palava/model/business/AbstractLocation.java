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

import com.google.common.base.Objects;

import de.cosmocode.rendering.Renderer;
import de.cosmocode.rendering.RenderingException;
import de.cosmocode.rendering.RenderingLevel;

/**
 * Abstract implementation of the {@link Location} interface.
 *
 * @since 
 * @author Willi Schoenborn
 */
public abstract class AbstractLocation implements Location {

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        } else if (that instanceof Location) {
            final Location other = Location.class.cast(that);
            return Objects.equal(this.getLatitude(), other.getLatitude()) &&
                Objects.equal(this.getLongitude(), other.getLongitude());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getLatitude(), getLongitude());
    }

    @Override
    public void render(Renderer renderer, RenderingLevel level) throws RenderingException {
        renderer.
            key("latitude").value(getLatitude()).
            key("longitude").value(getLongitude());
    }

    @Override
    public String toString() {
        return "Location {latitude=" + getLatitude() + ", longitude=" + getLongitude() + "}";
    }
    
    

}
